package org.murashov.kotlinandroidarchitecture.presentation.scheduler

import org.murashov.kotlinandroidarchitecture.domain.scheduler.PostExecutionSchedulerHolder
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by artemmurashov on 8/24/17.
 */
@Singleton
class PostExecutionSchedulerHolderImpl @Inject constructor() : PostExecutionSchedulerHolder {
    override val scheduler: Scheduler = AndroidSchedulers.mainThread()
}