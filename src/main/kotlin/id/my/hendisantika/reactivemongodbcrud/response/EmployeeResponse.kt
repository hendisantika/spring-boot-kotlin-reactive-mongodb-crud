package id.my.hendisantika.reactivemongodbcrud.response

import id.my.hendisantika.reactivemongodbcrud.model.Employee

/**
 * Created by IntelliJ IDEA.
 * Project : reactive-mongodb-crud
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 01/12/24
 * Time: 19.35
 * To change this template use File | Settings | File Templates.
 */
class EmployeeResponse(
    val id: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val company: CompanyResponse?
) {
    companion object {
        fun fromEntity(employee: Employee): EmployeeResponse =
            EmployeeResponse(
                id = employee.id!!.toHexString(),
                firstName = employee.firstName,
                lastName = employee.lastName,
                email = employee.email,
                company = employee.company?.let { CompanyResponse.fromEntity(it) }
            )
    }
}
