package com.leonardo.cart.di

import com.leonardo.cart.flow.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ListViewModel(get()) }
}