package com.kibettheophilus.graphql

import android.app.Application
import com.kibettheophilus.feature.di.featureModule
import dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GraphqlApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GraphqlApp)
            modules(
                listOf(
                    dataModule, featureModule
                )
            )
        }
    }
}