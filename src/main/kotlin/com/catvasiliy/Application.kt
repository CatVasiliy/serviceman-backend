package com.catvasiliy

import com.catvasiliy.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

@Suppress("UNUSED")
fun Application.module() {
    configureSerialization()
    configureDatabases()
    configureMonitoring()
    configureRouting()
}
