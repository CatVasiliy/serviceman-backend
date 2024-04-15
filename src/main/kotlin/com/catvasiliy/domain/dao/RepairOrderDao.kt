package com.catvasiliy.domain.dao

import com.catvasiliy.domain.model.repair_order.RepairOrder
import com.catvasiliy.domain.model.repair_order.RepairOrderPostBody

interface RepairOrderDao {
    suspend fun getRepairOrdersList(): List<RepairOrder>
    suspend fun getRepairOrderById(id: Int): RepairOrder?
    suspend fun insertRepairOrder(repairOrder: RepairOrderPostBody)
}