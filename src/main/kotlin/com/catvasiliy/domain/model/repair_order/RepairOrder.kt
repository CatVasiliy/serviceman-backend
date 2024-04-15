package com.catvasiliy.domain.model.repair_order

import kotlinx.serialization.Serializable

@Serializable
data class RepairOrder(
    val id: Int,
    val faultDescription: String?
)
