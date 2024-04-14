package com.catvasiliy.plugins

import com.catvasiliy.repair_orders.RepairOrderTable
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureDatabase() {
    val dbHost = environment.config.property("database.host").getString()
    val dbPort = environment.config.property("database.port").getString()
    val dbName = environment.config.property("database.name").getString()
    val dbUser = environment.config.property("database.user").getString()
    val dbPassword = environment.config.property("database.password").getString()

    val database = Database.connect(
        url = "jdbc:postgresql://$dbHost:$dbPort/$dbName",
        driver = "org.postgresql.Driver",
        user = dbUser,
        password = dbPassword
    )

    transaction(database) {
        SchemaUtils.create(RepairOrderTable)
    }
}