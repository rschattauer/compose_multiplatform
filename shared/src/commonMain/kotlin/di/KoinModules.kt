package di

import org.koin.core.KoinApplication
import repository.repositoryModules
import screen.screenModules

fun KoinApplication.initModules() {
    modules(platformModules)
    modules(screenModules)
    modules(repositoryModules)
}
