package org.murashov.kotlinandroidarchitecture.data.datastore.preferences

import android.content.SharedPreferences
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by artemmurashov on 8/22/17.
 */
@Singleton
class SharedPreferencesDataStore @Inject constructor(
        private val sharedPreferences: SharedPreferences
): PreferencesDataStore {
    private fun removeElement(key: String): Observable<Nothing> = Observable.create {
        sharedPreferences.edit().remove(key).apply()
        it.onComplete()
    }

    private fun hasElement(key: String): Observable<Boolean> = Observable.create {
        it.onNext(sharedPreferences.contains(key))
        it.onComplete()
    }

    private fun getBoolean(key: String): Observable<Boolean> = Observable.create {
        it.onNext(sharedPreferences.getBoolean(key, false))
        it.onComplete()
    }

    private fun putBoolean(key: String, flag: Boolean): Observable<Nothing> = Observable.create {
        sharedPreferences.edit().putBoolean(key, flag).apply()
        it.onComplete()
    }

    private fun getString(key: String): Observable<String> = Observable.create {
        if (sharedPreferences.contains(key)) {
            it.onNext(sharedPreferences.getString(key, ""))
        } else {
            it.onError(NoSuchElementException())
        }

        it.onComplete()
    }

    private fun putString(key: String, string: String): Observable<Nothing> = Observable.create {
        sharedPreferences.edit().putString(key, string).apply()
        it.onComplete()
    }
}