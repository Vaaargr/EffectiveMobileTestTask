package com.iushin.effectivemobiletesttask

import android.app.Application
import com.iushin.effectivemobiletesttask.di.dataModule
import com.iushin.effectivemobiletesttask.di.domainModule
import com.iushin.effectivemobiletesttask.di.repositoryModule
import com.iushin.effectivemobiletesttask.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(viewModelModule, dataModule, domainModule, repositoryModule)
        }
    }
}