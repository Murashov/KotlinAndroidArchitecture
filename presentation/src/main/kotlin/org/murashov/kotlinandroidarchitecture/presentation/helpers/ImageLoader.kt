package org.murashov.kotlinandroidarchitecture.presentation.helpers

import android.widget.ImageView
import org.murashov.kotlinandroidarchitecture.data.repository.ImageRepository
import org.murashov.kotlinandroidarchitecture.domain.scheduler.ExecutionSchedulerHolder
import org.murashov.kotlinandroidarchitecture.domain.scheduler.PostExecutionSchedulerHolder
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by artemmurashov on 8/30/17.
 */
@Singleton
class ImageLoader @Inject constructor(
        private val imageRepository: ImageRepository,
        private val executionSchedulerHolder: ExecutionSchedulerHolder,
        private val postExecutionSchedulerHolder: PostExecutionSchedulerHolder
) {
    fun load(cdnUid: String?, imageView: ImageView) {}
}