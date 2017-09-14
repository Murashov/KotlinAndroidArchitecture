package org.murashov.kotlinandroidarchitecture.data.datastore.api.retrofit

import org.murashov.kotlinandroidarchitecture.data.datastore.api.ApiDataStore
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by artemmurashov on 8/22/17.
 */
@Singleton
class RetrofitApiDataStore @Inject constructor(
        private val restApiService: RestApiService
) : ApiDataStore {
}