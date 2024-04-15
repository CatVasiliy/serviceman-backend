package com.catvasiliy.plugins

import com.catvasiliy.presentation.client.clientRoutes
import com.catvasiliy.presentation.repair_order.repairOrderRoutes
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        repairOrderRoutes()
        clientRoutes()
    }
}