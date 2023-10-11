package feature.preferences.api

import kotlinx.coroutines.flow.Flow

interface ValuePrefs<T : Any> {

    val currentValue: Flow<T>

    suspend fun rememberValue(value: T)

}