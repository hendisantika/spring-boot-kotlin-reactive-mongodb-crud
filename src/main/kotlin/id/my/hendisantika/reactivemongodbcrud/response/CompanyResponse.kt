package id.my.hendisantika.reactivemongodbcrud.response

import id.my.hendisantika.reactivemongodbcrud.model.Company

/**
 * Created by IntelliJ IDEA.
 * Project : reactive-mongodb-crud
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/12/24
 * Time: 19.34
 * To change this template use File | Settings | File Templates.
 */
class CompanyResponse(
    val id: String,
    val name: String,
    val address: String
) {
    companion object {
        fun fromEntity(company: Company): CompanyResponse =
            CompanyResponse(
                id = company.id!!,
                name = company.name,
                address = company.address
            )
    }
}
