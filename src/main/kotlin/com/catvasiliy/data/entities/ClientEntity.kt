package com.catvasiliy.data.entities

import com.catvasiliy.data.PostgreSqlDatabase.dbQuery
import com.catvasiliy.domain.dao.ClientDao
import com.catvasiliy.domain.model.client.Client
import com.catvasiliy.domain.model.client.ClientPostBody
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll

object ClientEntity : Table("clients"), ClientDao {

    val id = integer("id").autoIncrement().uniqueIndex()
    val firstName = varchar("first_name", 128)
    val lastName = varchar("last_name", 128)
    val patronymic = varchar("patronymic", 128).nullable()
    val address = varchar("address", 255)
    val phoneNumber = varchar("phone_number", 32)

    override val primaryKey: PrimaryKey = PrimaryKey(id)

    override suspend fun getClientsList(): List<Client> = dbQuery {
        selectAll().map(ResultRow::toClient)
    }

    override suspend fun getClientById(id: Int): Client? = dbQuery {
        selectAll().where { ClientEntity.id eq id }.map(ResultRow::toClient).singleOrNull()
    }

    override suspend fun insertClient(client: ClientPostBody): Unit = dbQuery {
        insert { insertStatement ->
            insertStatement[firstName] = client.firstName
            insertStatement[lastName] = client.lastName
            insertStatement[patronymic] = client.patronymic
            insertStatement[address] = client.address
            insertStatement[phoneNumber] = client.phoneNumber
        }
    }
}

private fun ResultRow.toClient(): Client {
    return Client(
        id = this[ClientEntity.id],
        firstName = this[ClientEntity.firstName],
        lastName = this[ClientEntity.lastName],
        patronymic = this[ClientEntity.patronymic],
        address = this[ClientEntity.address],
        phoneNumber = this[ClientEntity.phoneNumber]
    )
}