package org.murashov.kotlinandroidarchitecture.data.scheduler

import org.murashov.kotlinandroidarchitecture.domain.scheduler.ExecutionSchedulerHolder
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by artemmurashov on 8/24/17.
 */
@Singleton
class ExecutionSchedulerHolderImpl @Inject constructor() : ExecutionSchedulerHolder {
    override val scheduler = Schedulers.io()
}