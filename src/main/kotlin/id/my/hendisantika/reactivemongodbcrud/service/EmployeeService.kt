package id.my.hendisantika.reactivemongodbcrud.service

import id.my.hendisantika.reactivemongodbcrud.exception.NotFoundException
import id.my.hendisantika.reactivemongodbcrud.model.Employee
import id.my.hendisantika.reactivemongodbcrud.repository.EmployeeRepository
import id.my.hendisantika.reactivemongodbcrud.request.EmployeeRequest
import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * Created by IntelliJ IDEA.
 * Project : reactive-mongodb-crud
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/12/24
 * Time: 19.42
 * To change this template use File | Settings | File Templates.
 */
@Service
class EmployeeService(
    private val companyService: CompanyService,
    private val employeeRepository: EmployeeRepository
) {
    fun createEmployee(request: EmployeeRequest): Mono<Employee> {
        val companyId = request.companyId

        return if (companyId == null) {
            createEmployeeWithoutCompany(request)
        } else {
            createEmployeeWithCompany(companyId, request)
        }
    }

    private fun createEmployeeWithoutCompany(request: EmployeeRequest): Mono<Employee> {
        return employeeRepository.save(
            Employee(
                firstName = request.firstName,
                lastName = request.lastName,
                email = request.email,
                company = null
            )
        )
    }

    private fun createEmployeeWithCompany(companyId: String, request: EmployeeRequest) =
        companyService.findById(companyId)
            .flatMap {
                employeeRepository.save(
                    Employee(
                        firstName = request.firstName,
                        lastName = request.lastName,
                        email = request.email,
                        company = it
                    )
                )
            }

    fun findAll(): Flux<Employee> = employeeRepository.findAll()

    fun findAllByCompanyId(id: String): Flux<Employee> = employeeRepository.findByCompanyId(id)

    fun findById(id: ObjectId): Mono<Employee> =
        employeeRepository.findById(id)
            .switchIfEmpty {
                Mono.error(
                    NotFoundException("Employee with id $id not found")
                )
            }

    fun updateEmployee(id: ObjectId, request: EmployeeRequest): Mono<Employee> {
        val employeeToUpdate = findById(id)

        val companyId = request.companyId
        return if (companyId == null) {
            updateEmployeeWithoutCompany(employeeToUpdate, request)
        } else {
            updateEmployeeWithCompany(companyId, employeeToUpdate, request)
        }
    }

    private fun updateEmployeeWithoutCompany(employeeToUpdate: Mono<Employee>, request: EmployeeRequest) =
        employeeToUpdate.flatMap {
            employeeRepository.save(
                it.apply {
                    firstName = request.firstName
                    lastName = request.lastName
                    email = request.email
                    company = null
                }
            )
        }

    private fun updateEmployeeWithCompany(
        companyId: String,
        employeeToUpdate: Mono<Employee>,
        request: EmployeeRequest
    ) =
        companyService.findById(companyId)
            .zipWith(employeeToUpdate)
            .flatMap {
                employeeRepository.save(
                    it.t2.apply {
                        firstName = request.firstName
                        lastName = request.lastName
                        email = request.email
                        company = it.t1
                    }
                )
            }

    fun deleteById(id: ObjectId): Mono<Void> {
        return findById(id)
            .flatMap(employeeRepository::delete)
    }
}
