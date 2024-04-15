package com.catvasiliy.data.repair_order

import com.catvasiliy.data.client.ClientTable
import org.jetbrains.exposed.dao.id.IntIdTable

object RepairOrderTable : IntIdTable("repair_order") {

    val faultDescription = varchar("fault_description", 128).nullable()
    val client = reference("client", ClientTable)
}