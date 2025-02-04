package id.my.hendisantika.reactivemongodbcrud.service

import id.my.hendisantika.reactivemongodbcrud.exception.NotFoundException
import id.my.hendisantika.reactivemongodbcrud.model.Company
import id.my.hendisantika.reactivemongodbcrud.model.Employee
import id.my.hendisantika.reactivemongodbcrud.repository.CompanyRepository
import id.my.hendisantika.reactivemongodbcrud.repository.EmployeeRepository
import id.my.hendisantika.reactivemongodbcrud.request.CompanyRequest
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
 * Time: 19.36
 * To change this template use File | Settings | File Templates.
 */
@Service
class CompanyService(
    private val companyRepository: CompanyRepository,
    private val employeeRepository: EmployeeRepository
) {
    fun createCompany(request: CompanyRequest): Mono<Company> =
        companyRepository.save(
            Company(
                name = request.name,
                address = request.address
            )
        )

    fun findAll(): Flux<Company> = companyRepository.findAll()


    fun findById(id: String): Mono<Company> =
        companyRepository.findById(id)
            .switchIfEmpty {
                Mono.error(
                    NotFoundException("Company with id $id not found")
                )
            }

    fun updateCompany(id: String, request: CompanyRequest): Mono<Company> =
        findById(id)
            .flatMap {
                companyRepository.save(
                    it.apply {
                        name = request.name
                        address = request.address
                    }
                )
            }
            .doOnSuccess { updateCompanyEmployees(it).subscribe() }

    fun deleteById(id: String): Mono<Void> = findById(id).flatMap(companyRepository::delete)

    private fun updateCompanyEmployees(updatedCompany: Company): Flux<Employee> =
        employeeRepository.saveAll(
            employeeRepository.findByCompanyId(updatedCompany.id!!)
                .map { it.apply { company = updatedCompany } }
        )
}
