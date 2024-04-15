package com.catvasiliy.data

data class PostgreSqlDatabaseConfig(
    val host: String,
    val port: String,
    val name: String,
    val user: String,
    val password: String
) {
    val databaseUrl = "jdbc:postgresql://$host:$port/$name"

    companion object {
        const val DRIVER = "org.postgresql.Driver"
    }
}