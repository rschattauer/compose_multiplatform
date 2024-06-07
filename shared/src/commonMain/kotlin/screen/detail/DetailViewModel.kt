package screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import repository.settings.Settings

class DetailViewModel(
    initialTick: Int,
    settings: Settings,
) : ViewModel() {

    private val _state = MutableStateFlow(initialTick)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            while (true) {
                delay(1000)
                if (settings.isOnboardingCompleted.firstOrNull() == true) {
                    _state.update { currentValue -> currentValue + 1 }
                }
            }
        }
    }

    companion object {
        internal const val DETAIL_TICK_ARGUMENT_KEY = "DETAIL_TICK_ARGUMENT_KEY"
    }
}
