package org.murashov.kotlinandroidarchitecture.data.datastore.api

import org.murashov.kotlinandroidarchitecture.data.datastore.preferences.PreferencesDataStore
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by artemmurashov on 8/22/17.
 */
@Singleton
class UrlProvider @Inject constructor(private val preferencesDataStore: PreferencesDataStore) {
    fun getApiBaseUrl() = ""
}