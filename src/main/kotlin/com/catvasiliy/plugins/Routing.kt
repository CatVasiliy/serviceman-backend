package com.catvasiliy.plugins

import com.catvasiliy.presentation.repair_orders.repairOrderRoutes
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        repairOrderRoutes()
    }
}