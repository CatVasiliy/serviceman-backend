package com.catvasiliy.data.entities

import com.catvasiliy.data.PostgreSqlDatabase.dbQuery
import com.catvasiliy.domain.dao.RepairOrderDao
import com.catvasiliy.domain.model.repair_order.RepairOrder
import com.catvasiliy.domain.model.repair_order.RepairOrderPostBody
import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll

object RepairOrderEntity : Table("repair_orders"), RepairOrderDao {

    val id = integer("id").autoIncrement().uniqueIndex()
    val faultDescription = varchar("fault_description", 128).nullable()
    val clientId = reference("client_id", ClientEntity.id)

    override val primaryKey: PrimaryKey = PrimaryKey(id)

    override suspend fun getRepairOrdersList(): List<RepairOrder> = dbQuery {
        selectAll().map(ResultRow::toRepairOrder)
    }

    override suspend fun getRepairOrderById(id: Int): RepairOrder? = dbQuery {
        selectAll().where { RepairOrderEntity.id eq id }.map(ResultRow::toRepairOrder).singleOrNull()
    }

    override suspend fun insertRepairOrder(repairOrder: RepairOrderPostBody): Unit = dbQuery {
        insert { insertStatement ->
            insertStatement[faultDescription] = repairOrder.faultDescription
            insertStatement[clientId] = repairOrder.clientId
        }
    }
}

private fun ResultRow.toRepairOrder() = RepairOrder(
    id = this[RepairOrderEntity.id],
    faultDescription = this[RepairOrderEntity.faultDescription],
    clientId = this[RepairOrderEntity.clientId]
)