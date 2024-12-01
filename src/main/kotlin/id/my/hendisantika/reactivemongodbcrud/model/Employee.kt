package id.my.hendisantika.reactivemongodbcrud.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id

/**
 * Created by IntelliJ IDEA.
 * Project : reactive-mongodb-crud
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/12/24
 * Time: 19.28
 * To change this template use File | Settings | File Templates.
 */
data class Employee(
    @Id
    val id: ObjectId? = null,
    var firstName: String,
    var lastName: String,
    var email: String,
    var company: Company?
)
