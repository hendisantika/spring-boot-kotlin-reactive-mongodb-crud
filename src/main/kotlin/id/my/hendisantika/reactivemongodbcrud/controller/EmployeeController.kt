package id.my.hendisantika.reactivemongodbcrud.controller

import id.my.hendisantika.reactivemongodbcrud.request.EmployeeRequest
import id.my.hendisantika.reactivemongodbcrud.response.EmployeeResponse
import id.my.hendisantika.reactivemongodbcrud.service.EmployeeService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

/**
 * Created by IntelliJ IDEA.
 * Project : reactive-mongodb-crud
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/12/24
 * Time: 19.53
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/api/employee")
class EmployeeController(
    private val employeeService: EmployeeService
) {
    @PostMapping
    fun createEmployee(@RequestBody request: EmployeeRequest): Mono<EmployeeResponse> {
        return employeeService.createEmployee(request)
            .map { EmployeeResponse.fromEntity(it) }
    }

    @GetMapping
    fun findAllEmployees(): Flux<EmployeeResponse> {
        return employeeService.findAll()
            .map { EmployeeResponse.fromEntity(it) }
    }
}
