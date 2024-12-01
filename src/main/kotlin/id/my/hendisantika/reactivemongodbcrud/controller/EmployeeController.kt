package id.my.hendisantika.reactivemongodbcrud.controller

import id.my.hendisantika.reactivemongodbcrud.request.EmployeeRequest
import id.my.hendisantika.reactivemongodbcrud.response.EmployeeResponse
import id.my.hendisantika.reactivemongodbcrud.service.EmployeeService
import org.bson.types.ObjectId
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

    @GetMapping("/{id}")
    fun findEmployeeById(@PathVariable id: ObjectId): Mono<EmployeeResponse> {
        return employeeService.findById(id)
            .map { EmployeeResponse.fromEntity(it) }
    }

    @GetMapping("/company/{companyId}")
    fun findAllByCompanyId(@PathVariable companyId: String): Flux<EmployeeResponse> {
        return employeeService.findAllByCompanyId(companyId)
            .map { EmployeeResponse.fromEntity(it) }
    }

    @PutMapping("/{id}")
    fun updateUpdateEmployee(
        @PathVariable id: ObjectId,
        @RequestBody request: EmployeeRequest
    ): Mono<EmployeeResponse> {
        return employeeService.updateEmployee(id, request)
            .map { EmployeeResponse.fromEntity(it) }
    }

    @DeleteMapping("/{id}")
    fun deleteEmployee(@PathVariable id: ObjectId): Mono<Void> {
        return employeeService.deleteById(id)
    }
}
