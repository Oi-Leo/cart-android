package com.leonardo.cart

import android.app.Application
import com.leonardo.cart.di.repositoryModule
import com.leonardo.cart.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                repositoryModule,
                viewModelModule
            )
        }
    }

}