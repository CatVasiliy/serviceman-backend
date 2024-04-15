package com.catvasiliy.presentation.client

import com.catvasiliy.domain.model.client.ClientPostBody
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*
import org.koin.ktor.ext.inject

private const val URL = "/clients"

fun Route.clientRoutes() {

    val clientService by inject<ClientService>()

    route(URL) {

        get {
            val clientsList = clientService.getClientsList()

            call.respond(clientsList)
        }

        get("/{id}") {
            val id = call.parameters.getOrFail("id").toInt()
            val client = clientService.getClientById(id)

            if (client == null) {
                call.respond(HttpStatusCode.NotFound)
                return@get
            }

            call.respond(client)
        }

        post {
            val client = call.receive<ClientPostBody>()

            clientService.createClient(client)

            call.respond(HttpStatusCode.Created)
        }
    }
}