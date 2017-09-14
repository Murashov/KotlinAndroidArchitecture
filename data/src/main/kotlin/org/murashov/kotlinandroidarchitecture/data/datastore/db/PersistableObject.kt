package org.murashov.kotlinandroidarchitecture.data.datastore.db

import org.murashov.kotlinandroidarchitecture.data.model.DataModel

/**
 * Created by artemmurashov on 9/4/17.
 */
interface PersistableObject<out T : DataModel<*>> {
    fun toDataModel(): T
}