package repository.settings

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

private const val PATH = "build/settings_preferences.preferences_pb"

fun dataStore(): DataStore<Preferences> = dataStore(producePath = { PATH })
