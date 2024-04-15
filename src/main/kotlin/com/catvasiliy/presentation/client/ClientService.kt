package com.catvasiliy.presentation.client

import com.catvasiliy.domain.dao.ClientDao
import com.catvasiliy.domain.model.client.Client
import com.catvasiliy.domain.model.client.ClientPostBody

class ClientService(private val clientDao: ClientDao) {

    suspend fun getClientsList(): List<Client> {
        return clientDao.getClientsList()
    }

    suspend fun getClientById(id: Int): Client? {
        return clientDao.getClientById(id)
    }

    suspend fun createClient(client: ClientPostBody) {
        clientDao.insertClient(client)
    }
}