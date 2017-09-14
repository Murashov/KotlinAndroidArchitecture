package org.murashov.kotlinandroidarchitecture.data.datastore.image

import android.content.Context
import android.graphics.Bitmap
import com.squareup.picasso.Picasso
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by artemmurashov on 8/30/17.
 */
@Singleton
class PicassoImageDataStore @Inject constructor(
        private val context: Context
) : ImageDataStore {
    override fun loadImageByUrl(url: String): Observable<Bitmap> = Observable.create {
        try {
            it.onNext(Picasso.with(context).load(url).get())
            it.onComplete()
        } catch (e: Exception) {
            it.onError(e)
        }
    }
}