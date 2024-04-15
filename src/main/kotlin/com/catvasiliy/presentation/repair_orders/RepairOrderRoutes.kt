package com.catvasiliy.presentation.repair_orders

import com.catvasiliy.domain.model.repair_order.RepairOrderPostBody
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*
import org.koin.ktor.ext.inject

private const val URL = "/repair-orders"

fun Route.repairOrderRoutes() {

    val repairOrderService by inject<RepairOrderService>()

    route(URL) {

        get {
            val repairOrdersList = repairOrderService.getRepairOrdersList()

            call.respond(repairOrdersList)
        }

        get("/{id}") {
            val id = call.parameters.getOrFail("id").toInt()
            val repairOrder = repairOrderService.getRepairOrderById(id)

            if (repairOrder == null) {
                call.respond(HttpStatusCode.NotFound)
                return@get
            }

            call.respond(repairOrder)
        }

        post {
            val repairOrder = call.receive<RepairOrderPostBody>()

            repairOrderService.createRepairOrder(repairOrder)

            call.respond(HttpStatusCode.Created)
        }
    }
}