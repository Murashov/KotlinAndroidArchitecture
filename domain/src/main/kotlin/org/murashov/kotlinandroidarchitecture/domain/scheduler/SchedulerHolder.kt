package org.murashov.kotlinandroidarchitecture.domain.scheduler

import io.reactivex.Scheduler

/**
 * Created by artemmurashov on 8/24/17.
 */
interface SchedulerHolder {
    val scheduler: Scheduler
}