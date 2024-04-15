package com.catvasiliy.data

import com.catvasiliy.data.entities.ClientEntity
import com.catvasiliy.data.entities.RepairOrderEntity
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

object PostgreSqlDatabase {

    private val entities: Array<Table> = arrayOf(
        RepairOrderEntity,
        ClientEntity
    )

    fun initialize(config: PostgreSqlDatabaseConfig) {
        val database = Database.connect(
            url = config.databaseUrl,
            driver = PostgreSqlDatabaseConfig.DRIVER,
            user = config.user,
            password = config.password
        )

        transaction(database) {
            SchemaUtils.create(*entities)
        }
    }

    suspend fun <T> dbQuery(query: suspend () -> T): T = newSuspendedTransaction(Dispatchers.IO) { query() }
}