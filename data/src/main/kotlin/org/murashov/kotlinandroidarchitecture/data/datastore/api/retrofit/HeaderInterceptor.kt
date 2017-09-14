package org.murashov.kotlinandroidarchitecture.data.datastore.api.retrofit

import okhttp3.Interceptor
import okhttp3.Response
import org.murashov.kotlinandroidarchitecture.data.datastore.preferences.PreferencesDataStore
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by artemmurashov on 8/22/17.
 */
@Singleton
class HeaderInterceptor @Inject constructor(
        private val preferencesDataStore: PreferencesDataStore
): Interceptor {
    override fun intercept(chain: Interceptor.Chain?): Response = chain!!.proceed(
            chain.request().newBuilder()
                    .build()
    )
}