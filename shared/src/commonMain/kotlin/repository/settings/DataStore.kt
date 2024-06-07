package repository.settings

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath

/**
 * Gets the singleton DataStore instance, creating it if necessary.
 */
fun dataStore(
    producePath: () -> String,
): DataStore<Preferences> = PreferenceDataStoreFactory.createWithPath(produceFile = { producePath().toPath() })

internal const val DATASTORE_FILE_NAME = "composeMultiplatform.preferences_pb"
