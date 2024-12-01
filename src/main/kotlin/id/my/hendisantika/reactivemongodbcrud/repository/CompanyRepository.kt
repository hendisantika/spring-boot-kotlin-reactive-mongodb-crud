package id.my.hendisantika.reactivemongodbcrud.repository

import id.my.hendisantika.reactivemongodbcrud.model.Company
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

/**
 * Created by IntelliJ IDEA.
 * Project : reactive-mongodb-crud
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/12/24
 * Time: 19.29
 * To change this template use File | Settings | File Templates.
 */
internal interface CompanyRepository : ReactiveMongoRepository<Company, String>
