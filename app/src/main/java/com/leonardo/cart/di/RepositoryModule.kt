package com.leonardo.cart.di

import com.leonardo.cart.flow.list.ListRepository
import org.koin.dsl.module

val repositoryModule = module {
    single {
        ListRepository()
    }
}