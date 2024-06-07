package screen.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import repository.settings.Settings

class OnboardingViewModel(
    private val settings: Settings,
) : ViewModel() {

    val isOnboardingCompleted: Flow<Boolean> = settings.isOnboardingCompleted
        .onStart { delay(MINIMUM_SPLASH_SCREEN_DELAY) }

    fun completeOnboarding() {
        viewModelScope.launch {
            settings.setOnboardingCompleted()
        }
    }

    companion object {
        private const val MINIMUM_SPLASH_SCREEN_DELAY = 2_000L
    }
}
