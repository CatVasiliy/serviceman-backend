package com.catvasiliy

import com.catvasiliy.plugins.configureDatabase
import com.catvasiliy.plugins.configureMonitoring
import com.catvasiliy.plugins.configureRouting
import com.catvasiliy.plugins.configureSerialization
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

@Suppress("unused")
fun Application.module() {
    configureSerialization()
    configureMonitoring()
    configureRouting()
    configureDatabase()
}
