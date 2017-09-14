package org.murashov.kotlinandroidarchitecture.data.datastore.db

import org.murashov.kotlinandroidarchitecture.data.model.DataModel

/**
 * Created by artemmurashov on 9/4/17.
 */
interface PersistableObjectFactory<T : DataModel<*>, out P : PersistableObject<T>> {
    fun fromDataModel(model: T): P

    fun fromNullableDataModel(model: T?) = if (model != null) {
        fromDataModel(model)
    } else null
}