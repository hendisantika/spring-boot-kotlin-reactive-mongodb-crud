package id.my.hendisantika.reactivemongodbcrud.service

import id.my.hendisantika.reactivemongodbcrud.repository.CompanyRepository
import id.my.hendisantika.reactivemongodbcrud.repository.EmployeeRepository
import org.springframework.stereotype.Service

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
)
