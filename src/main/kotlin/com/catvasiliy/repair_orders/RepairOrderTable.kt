package com.catvasiliy.repair_orders

import com.catvasiliy.repair_orders.RepairOrderTable.faultDescription
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object RepairOrderTable : Table("repair_orders"), RepairOrderDao {

    val id = integer("id").autoIncrement().uniqueIndex()
    val faultDescription = varchar("fault_description", 128).nullable()

    override val primaryKey: PrimaryKey = PrimaryKey(id)

    override fun getRepairOrdersList(): List<RepairOrder> = transaction {
        selectAll().map(ResultRow::toRepairOrder)
    }

    override fun getRepairOrderById(id: Int): RepairOrder? = transaction {
        select { this@RepairOrderTable.id eq id }.map(ResultRow::toRepairOrder).singleOrNull()
    }

    override fun insertRepairOrder(repairOrder: RepairOrder): Unit = transaction {
        insert { insertStatement ->
            insertStatement[faultDescription] = repairOrder.faultDescription
        }
    }
}

private fun ResultRow.toRepairOrder() = RepairOrder(
    faultDescription = this[faultDescription]
)