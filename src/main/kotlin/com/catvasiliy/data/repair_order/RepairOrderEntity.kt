package com.catvasiliy.data.repair_order

import com.catvasiliy.data.client.ClientEntity
import com.catvasiliy.domain.model.repair_order.RepairOrder
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class RepairOrderEntity(id: EntityID<Int>) : IntEntity(id) {

    companion object : IntEntityClass<RepairOrderEntity>(RepairOrderTable)

    var faultDescription by RepairOrderTable.faultDescription
    var client by ClientEntity referencedOn RepairOrderTable.client

    fun toRepairOrder() = RepairOrder(
        id = id.value,
        faultDescription = faultDescription,
        client = client.toClient()
    )
}