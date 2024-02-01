package repository.settings

import org.koin.dsl.module

internal val settingsModule
    get() = module {
        single<Settings> { SettingsImpl(dataStore = get()) }
    }
