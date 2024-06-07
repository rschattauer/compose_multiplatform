package repository.settings

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SettingsImpl(private val dataStore: DataStore<Preferences>) : Settings {

    private val onboardingCompletedKey = booleanPreferencesKey("onboardingCompleted")

    override val isOnboardingCompleted: Flow<Boolean> =
        dataStore.data.map { preferences -> preferences[onboardingCompletedKey] ?: false }

    override suspend fun setOnboardingCompleted() {
        dataStore.edit { preferences ->
            preferences[onboardingCompletedKey] = true
        }
    }
}
