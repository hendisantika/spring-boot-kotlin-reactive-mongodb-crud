package id.my.hendisantika.reactivemongodbcrud.controller

import id.my.hendisantika.reactivemongodbcrud.service.CompanyService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by IntelliJ IDEA.
 * Project : reactive-mongodb-crud
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/12/24
 * Time: 19.47
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/api/company")
class CompanyController(
    private val companyService: CompanyService
)
