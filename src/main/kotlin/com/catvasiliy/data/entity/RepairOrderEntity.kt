package com.catvasiliy.data.entity

import com.catvasiliy.domain.model.repair_order.RepairOrder
import com.catvasiliy.domain.dao.RepairOrderDao
import com.catvasiliy.domain.model.repair_order.RepairOrderPostBody
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object RepairOrderEntity : Table("repair_orders"), RepairOrderDao {

    val id = integer("id").autoIncrement().uniqueIndex()
    val faultDescription = varchar("fault_description", 128).nullable()

    override val primaryKey: PrimaryKey = PrimaryKey(id)

    override fun getRepairOrdersList(): List<RepairOrder> = transaction {
        selectAll().map(ResultRow::toRepairOrder)
    }

    override fun getRepairOrderById(id: Int): RepairOrder? = transaction {
        select { RepairOrderEntity.id eq id }.map(ResultRow::toRepairOrder).singleOrNull()
    }

    override fun insertRepairOrder(repairOrder: RepairOrderPostBody): Unit = transaction {
        insert { insertStatement ->
            insertStatement[faultDescription] = repairOrder.faultDescription
        }
    }
}

private fun ResultRow.toRepairOrder() = RepairOrder(
    id = this[RepairOrderEntity.id],
    faultDescription = this[RepairOrderEntity.faultDescription]
)