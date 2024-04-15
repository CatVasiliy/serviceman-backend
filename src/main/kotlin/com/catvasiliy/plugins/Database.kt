package com.catvasiliy.plugins

import com.catvasiliy.data.PostgreSqlDatabase
import com.catvasiliy.data.PostgreSqlDatabaseConfig
import io.ktor.server.application.*

fun Application.configureDatabase() {
    val databaseConfig = PostgreSqlDatabaseConfig(
        host = environment.config.property("database.host").getString(),
        port = environment.config.property("database.port").getString(),
        name = environment.config.property("database.name").getString(),
        user = environment.config.property("database.user").getString(),
        password = environment.config.property("database.password").getString()
    )

    PostgreSqlDatabase.initialize(databaseConfig)
}