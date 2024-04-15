package com.catvasiliy.data.client

import com.catvasiliy.domain.model.client.Client
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class ClientEntity(id: EntityID<Int>) : IntEntity(id) {

    companion object : IntEntityClass<ClientEntity>(ClientTable)

    var firstName by ClientTable.firstName
    var lastName by ClientTable.lastName
    var patronymic by ClientTable.patronymic
    var address by ClientTable.address
    var phoneNumber by ClientTable.phoneNumber

    fun toClient() = Client(
        id = id.value,
        firstName = firstName,
        lastName = lastName,
        patronymic = patronymic,
        address = address,
        phoneNumber = phoneNumber
    )
}