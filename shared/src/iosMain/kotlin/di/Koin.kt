package di

import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        initModules()
    }
}
