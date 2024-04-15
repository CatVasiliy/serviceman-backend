package com.catvasiliy.di

import com.catvasiliy.data.client.ClientDaoImpl
import com.catvasiliy.data.repair_order.RepairOrderDaoImpl
import com.catvasiliy.domain.dao.ClientDao
import com.catvasiliy.domain.dao.RepairOrderDao
import com.catvasiliy.presentation.client.ClientService
import com.catvasiliy.presentation.repair_order.RepairOrderService
import org.koin.dsl.module

val appModule = module {
    single<RepairOrderDao> { RepairOrderDaoImpl() }
    single<ClientDao> { ClientDaoImpl() }

    single { RepairOrderService(get(), get()) }
    single { ClientService(get()) }
}