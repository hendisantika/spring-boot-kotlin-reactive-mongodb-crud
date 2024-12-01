package id.my.hendisantika.reactivemongodbcrud.service

import id.my.hendisantika.reactivemongodbcrud.model.Employee
import id.my.hendisantika.reactivemongodbcrud.repository.EmployeeRepository
import id.my.hendisantika.reactivemongodbcrud.request.EmployeeRequest
import org.springframework.stereotype.Service
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
}
