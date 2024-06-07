package repository

import repository.settings.settingsModule

val repositoryModules
    get() = listOf(
        settingsModule,
    )
