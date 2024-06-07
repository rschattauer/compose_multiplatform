package repository.settings

import kotlinx.coroutines.flow.Flow

interface Settings {
    val isOnboardingCompleted: Flow<Boolean>
    suspend fun setOnboardingCompleted()
}
