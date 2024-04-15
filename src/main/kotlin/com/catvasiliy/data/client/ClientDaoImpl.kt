package com.catvasiliy.data.client

import com.catvasiliy.data.PostgreSqlDatabase.dbQuery
import com.catvasiliy.domain.dao.ClientDao
import com.catvasiliy.domain.model.client.Client
import com.catvasiliy.domain.model.client.ClientPostBody

class ClientDaoImpl : ClientDao {

    override suspend fun getClientsList(): List<Client> = dbQuery {
        ClientEntity.all().map(ClientEntity::toClient)
    }

    override suspend fun getClientById(id: Int): Client? = dbQuery {
        ClientEntity.findById(id)?.toClient()
    }

    override suspend fun insertClient(client: ClientPostBody): Unit = dbQuery {
        ClientEntity.new {
            firstName = client.firstName
            lastName = client.lastName
            patronymic = client.patronymic
            address = client.address
            phoneNumber = client.phoneNumber
        }
    }
}