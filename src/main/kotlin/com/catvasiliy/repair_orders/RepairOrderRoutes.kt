package com.catvasiliy.repair_orders

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*

private const val URL = "/repair-orders"

fun Application.repairOrderRoutes() {
    routing {
        getRepairOrdersListRoute()
        createRepairOrderRoute()
        getRepairOrderByIdRoute()
    }
}

fun Route.getRepairOrdersListRoute() {
    get(URL) {
        val repairOrdersList = RepairOrderTable.getRepairOrdersList()

        call.respond(repairOrdersList)
    }
}

fun Route.createRepairOrderRoute() {
    post(URL) {
        val repairOrder = call.receive<RepairOrder>()

        RepairOrderTable.insertRepairOrder(repairOrder)

        call.respond(HttpStatusCode.Created)
    }
}

fun Route.getRepairOrderByIdRoute() {
    get("$URL/{id}") {
        val id = call.parameters.getOrFail("id").toInt()
        val repairOrder = RepairOrderTable.getRepairOrderById(id)

        if (repairOrder == null) {
            call.respond(HttpStatusCode.NotFound)
            return@get
        }

        call.respond(repairOrder)
    }
}