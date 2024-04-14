package com.catvasiliy.plugins

import com.catvasiliy.repair_orders.repairOrderRoutes
import io.ktor.server.application.*

fun Application.configureRouting() {
    repairOrderRoutes()
}