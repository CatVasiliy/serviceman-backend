package com.catvasiliy.repair_orders

import kotlinx.serialization.Serializable

@Serializable
data class RepairOrder(
    val faultDescription: String?
)
