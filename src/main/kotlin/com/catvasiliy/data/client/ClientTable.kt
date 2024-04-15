package com.catvasiliy.data.client

import org.jetbrains.exposed.dao.id.IntIdTable

object ClientTable : IntIdTable("client") {

    val firstName = varchar("first_name", 128)
    val lastName = varchar("last_name", 128)
    val patronymic = varchar("patronymic", 128).nullable()
    val address = varchar("address", 255)
    val phoneNumber = varchar("phone_number", 32)
}