package repository.settings

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences

fun dataStore(context: Context): DataStore<Preferences> =
    dataStore(producePath = { context.filesDir.resolve(DATASTORE_FILE_NAME).absolutePath })
