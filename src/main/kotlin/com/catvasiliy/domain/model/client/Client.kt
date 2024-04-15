package com.catvasiliy.domain.model.client

import kotlinx.serialization.Serializable

@Serializable
data class Client(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val patronymic: String?,
    val address: String,
    val phoneNumber: String
)
