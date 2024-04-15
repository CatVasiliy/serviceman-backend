package com.catvasiliy.domain.dao

import com.catvasiliy.domain.model.repair_order.RepairOrder
import com.catvasiliy.domain.model.repair_order.RepairOrderPostBody

interface RepairOrderDao {
    fun getRepairOrdersList(): List<RepairOrder>
    fun getRepairOrderById(id: Int): RepairOrder?
    fun insertRepairOrder(repairOrder: RepairOrderPostBody)
}