package com.catvasiliy.data.repair_order

import com.catvasiliy.data.PostgreSqlDatabase.dbQuery
import com.catvasiliy.data.client.ClientEntity
import com.catvasiliy.domain.dao.RepairOrderDao
import com.catvasiliy.domain.model.repair_order.RepairOrder
import com.catvasiliy.domain.model.repair_order.RepairOrderPostBody

class RepairOrderDaoImpl : RepairOrderDao {

    override suspend fun getRepairOrdersList(): List<RepairOrder> = dbQuery {
        RepairOrderEntity.all().map(RepairOrderEntity::toRepairOrder)
    }

    override suspend fun getRepairOrderById(id: Int): RepairOrder? = dbQuery {
        RepairOrderEntity.findById(id)?.toRepairOrder()
    }

    override suspend fun insertRepairOrder(repairOrder: RepairOrderPostBody): Unit = dbQuery {
        RepairOrderEntity.new {
            faultDescription = repairOrder.faultDescription
            client = ClientEntity[repairOrder.clientId]
        }
    }
}