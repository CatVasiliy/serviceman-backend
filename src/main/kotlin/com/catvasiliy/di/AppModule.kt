package com.catvasiliy.di

import com.catvasiliy.data.entities.ClientEntity
import com.catvasiliy.data.entities.RepairOrderEntity
import com.catvasiliy.domain.dao.ClientDao
import com.catvasiliy.domain.dao.RepairOrderDao
import com.catvasiliy.presentation.client.ClientService
import com.catvasiliy.presentation.repair_order.RepairOrderService
import org.koin.dsl.module

val appModule = module {
    single<RepairOrderDao> { RepairOrderEntity }
    single<ClientDao> { ClientEntity }

    single { RepairOrderService(get(), get()) }
    single { ClientService(get()) }
}