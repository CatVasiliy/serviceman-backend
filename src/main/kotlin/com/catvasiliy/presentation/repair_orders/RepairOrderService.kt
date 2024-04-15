package com.catvasiliy.presentation.repair_orders

import com.catvasiliy.domain.dao.RepairOrderDao
import com.catvasiliy.domain.model.repair_order.RepairOrder
import com.catvasiliy.domain.model.repair_order.RepairOrderPostBody

class RepairOrderService(private val repairOrderDao: RepairOrderDao) {

    fun getRepairOrdersList(): List<RepairOrder> {
        return repairOrderDao.getRepairOrdersList()
    }

    fun getRepairOrderById(id: Int): RepairOrder? {
        return repairOrderDao.getRepairOrderById(id)
    }

    fun createRepairOrder(repairOrder: RepairOrderPostBody) {
        repairOrderDao.insertRepairOrder(repairOrder)
    }
}