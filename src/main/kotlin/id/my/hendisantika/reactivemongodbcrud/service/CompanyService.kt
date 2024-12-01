package id.my.hendisantika.reactivemongodbcrud.service

import id.my.hendisantika.reactivemongodbcrud.model.Company
import id.my.hendisantika.reactivemongodbcrud.repository.CompanyRepository
import id.my.hendisantika.reactivemongodbcrud.repository.EmployeeRepository
import id.my.hendisantika.reactivemongodbcrud.request.CompanyRequest
import org.springframework.stereotype.Service
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
}
