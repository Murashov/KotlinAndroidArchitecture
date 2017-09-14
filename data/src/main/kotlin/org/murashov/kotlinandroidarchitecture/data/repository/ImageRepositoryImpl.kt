package org.murashov.kotlinandroidarchitecture.data.repository

import org.murashov.kotlinandroidarchitecture.data.datastore.api.UrlProvider
import org.murashov.kotlinandroidarchitecture.data.datastore.image.ImageDataStore
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by artemmurashov on 8/30/17.
 */
@Singleton
class ImageRepositoryImpl @Inject constructor(
        private val urlProvider: UrlProvider,
        private val imageDataStore: ImageDataStore
) : ImageRepository {
}