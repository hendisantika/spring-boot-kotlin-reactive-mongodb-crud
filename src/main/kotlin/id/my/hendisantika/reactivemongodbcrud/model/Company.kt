package id.my.hendisantika.reactivemongodbcrud.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

/**
 * Created by IntelliJ IDEA.
 * Project : reactive-mongodb-crud
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/12/24
 * Time: 19.26
 * To change this template use File | Settings | File Templates.
 */
@Document("companies")
data class Company(
    @Id
    val id: String? = null,
    var name: String,
    @Field("company_address")
    var address: String
)
