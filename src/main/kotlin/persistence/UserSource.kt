package persistence

import config.database._User
import models.User
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction


object UserSource {

    fun getUserById(id: Int) = transaction {
        _User.select { _User.id eq id }
                .first()
                .let(::User)
    }

    fun getUserByEmail(email: String) = transaction {
        _User.select { _User.email eq email }
                .first()
                .let(::User)
    }

}