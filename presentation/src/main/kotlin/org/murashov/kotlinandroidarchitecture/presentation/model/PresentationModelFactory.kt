package org.murashov.kotlinandroidarchitecture.presentation.model

import org.murashov.kotlinandroidarchitecture.domain.model.DomainModel

/**
 * Created by artemmurashov on 9/4/17.
 */
interface PresentationModelFactory<T : DomainModel, out P : PresentationModel<T>> {
    fun fromDomainModel(model: T): P

    fun fromNullableDomainModel(model: T?): P? = if (model != null) {
        fromDomainModel(model)
    } else null
}