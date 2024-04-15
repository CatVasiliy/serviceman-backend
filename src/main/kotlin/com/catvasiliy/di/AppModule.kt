package com.catvasiliy.di

import com.catvasiliy.data.entity.RepairOrderEntity
import com.catvasiliy.domain.dao.RepairOrderDao
import com.catvasiliy.presentation.repair_orders.RepairOrderService
import org.koin.dsl.module

val appModule = module {
    single<RepairOrderDao> { RepairOrderEntity }
    single { RepairOrderService(get()) }
}