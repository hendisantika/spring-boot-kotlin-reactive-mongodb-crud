package id.my.hendisantika.reactivemongodbcrud.controller

import id.my.hendisantika.reactivemongodbcrud.request.CompanyRequest
import id.my.hendisantika.reactivemongodbcrud.response.CompanyResponse
import id.my.hendisantika.reactivemongodbcrud.service.CompanyService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration

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
) {
    @PostMapping
    fun createCompany(@RequestBody request: CompanyRequest): Mono<CompanyResponse> {
        return companyService.createCompany(request)
            .map { CompanyResponse.fromEntity(it) }
    }

    @GetMapping
    fun findAllCompanies(): Flux<CompanyResponse> {
        return companyService.findAll()
            .map { CompanyResponse.fromEntity(it) }
            .delayElements(Duration.ofSeconds(2))
    }

    @GetMapping("/{id}")
    fun findCompanyById(@PathVariable id: String): Mono<CompanyResponse> {
        return companyService.findById(id)
            .map { CompanyResponse.fromEntity(it) }
    }

    @PutMapping("/{id}")
    fun updateCompany(
        @PathVariable id: String,
        @RequestBody request: CompanyRequest
    ): Mono<CompanyResponse> {
        return companyService.updateCompany(id, request)
            .map { CompanyResponse.fromEntity(it) }
    }
}
