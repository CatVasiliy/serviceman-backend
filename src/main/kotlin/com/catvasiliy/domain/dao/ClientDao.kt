package com.catvasiliy.domain.dao

import com.catvasiliy.domain.model.client.Client
import com.catvasiliy.domain.model.client.ClientPostBody

interface ClientDao {
    suspend fun getClientsList(): List<Client>
    suspend fun getClientById(id: Int): Client?
    suspend fun insertClient(client: ClientPostBody)
}