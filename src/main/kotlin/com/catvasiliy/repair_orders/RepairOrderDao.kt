package com.catvasiliy.repair_orders

interface RepairOrderDao {
    fun getRepairOrdersList(): List<RepairOrder>
    fun getRepairOrderById(id: Int): RepairOrder?
    fun insertRepairOrder(repairOrder: RepairOrder)
}