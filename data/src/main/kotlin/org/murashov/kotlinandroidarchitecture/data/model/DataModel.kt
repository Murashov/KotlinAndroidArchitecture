package org.murashov.kotlinandroidarchitecture.data.model

import org.murashov.kotlinandroidarchitecture.domain.model.DomainModel

/**
 * Created by artemmurashov on 9/4/17.
 */
interface DataModel<out T : DomainModel> {
    fun toDomainModel(): T
}