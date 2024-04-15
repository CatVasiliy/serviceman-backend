package com.catvasiliy.presentation.repair_order

import com.catvasiliy.domain.dao.ClientDao
import com.catvasiliy.domain.dao.RepairOrderDao
import com.catvasiliy.domain.model.repair_order.RepairOrder
import com.catvasiliy.domain.model.repair_order.RepairOrderPostBody

class RepairOrderService(
    private val repairOrderDao: RepairOrderDao,
    private val clientDao: ClientDao
) {

    suspend fun getRepairOrdersList(): List<RepairOrder> {
        return repairOrderDao.getRepairOrdersList()
    }

    suspend fun getRepairOrderById(id: Int): RepairOrder? {
        return repairOrderDao.getRepairOrderById(id)
    }

    suspend fun createRepairOrder(repairOrder: RepairOrderPostBody) {
        repairOrderDao.insertRepairOrder(repairOrder)
    }

    suspend fun checkClientExists(clientId: Int): Boolean {
        return clientDao.getClientById(clientId) != null
    }
}