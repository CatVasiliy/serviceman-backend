package com.catvasiliy.domain.model.repair_order

import com.catvasiliy.domain.model.client.Client
import kotlinx.serialization.Serializable

@Serializable
data class RepairOrder(
    val id: Int,
    val faultDescription: String?,
    val client: Client
)
