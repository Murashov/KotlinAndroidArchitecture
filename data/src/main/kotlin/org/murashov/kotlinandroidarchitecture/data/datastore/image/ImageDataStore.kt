package org.murashov.kotlinandroidarchitecture.data.datastore.image

import android.graphics.Bitmap
import io.reactivex.Observable

/**
 * Created by artemmurashov on 8/30/17.
 */
interface ImageDataStore {
    fun loadImageByUrl(url: String): Observable<Bitmap>
}