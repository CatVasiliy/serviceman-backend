package com.catvasiliy.domain.model.repair_order

import kotlinx.serialization.Serializable

@Serializable
data class RepairOrderPostBody(
    val faultDescription: String,
    val clientId: Int
)
