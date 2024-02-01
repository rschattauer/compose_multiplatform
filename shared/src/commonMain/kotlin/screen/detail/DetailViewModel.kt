package screen.detail

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

class DetailViewModel(initialTick: Int) : ViewModel() {

    private val _state = MutableStateFlow(initialTick)
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            while (true) {
                delay(1000)
                _state.update { currentValue -> currentValue + 1 }
            }
        }
    }
}
