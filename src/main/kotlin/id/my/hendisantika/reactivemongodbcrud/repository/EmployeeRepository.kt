package id.my.hendisantika.reactivemongodbcrud.repository

import id.my.hendisantika.reactivemongodbcrud.model.Employee
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux

/**
 * Created by IntelliJ IDEA.
 * Project : reactive-mongodb-crud
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/12/24
 * Time: 19.31
 * To change this template use File | Settings | File Templates.
 */
interface EmployeeRepository : ReactiveMongoRepository<Employee, ObjectId> {
    fun findByCompanyId(id: String): Flux<Employee>
}
