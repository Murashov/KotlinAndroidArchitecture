package org.murashov.kotlinandroidarchitecture.data.datastore.db.realm

import android.content.Context
import io.realm.Realm
import org.murashov.kotlinandroidarchitecture.data.datastore.db.DatabaseDataStore
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by artemmurashov on 9/4/17.
 */
@Singleton
class RealmDataStore @Inject constructor(context: Context) : DatabaseDataStore {
    init {
        Realm.init(context)
    }
}