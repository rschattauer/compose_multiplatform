package dev.schattauer.compose

import android.app.Application
import com.mapbox.common.MapboxOptions
import di.initModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        MapboxOptions.accessToken = BuildConfig.MAPBOX_PUBLIC_TOKEN

        startKoin {
            androidContext(this@MainApplication)
            androidLogger()
            initModules()
        }
    }
}
