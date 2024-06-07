package screen.detail

import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

internal val detailModule
    get() = module {
        viewModelOf(::DetailViewModel)
    }
