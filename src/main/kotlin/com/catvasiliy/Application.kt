package com.catvasiliy

import com.catvasiliy.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

@Suppress("unused")
fun Application.module() {
    configureRouting()
    configureDependencyInjection()
    configureSerialization()
    configureLogging()
    configureDatabase()
}
