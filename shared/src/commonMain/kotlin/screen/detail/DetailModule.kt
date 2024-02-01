package screen.detail

import org.koin.dsl.module

internal val detailModule
    get() = module {
        factory { (initialTick: Int) ->
            DetailViewModel(initialTick)
        }
    }
