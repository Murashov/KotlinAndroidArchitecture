package org.murashov.kotlinandroidarchitecture.domain.interactor

import org.murashov.kotlinandroidarchitecture.domain.scheduler.ExecutionSchedulerHolder
import org.murashov.kotlinandroidarchitecture.domain.scheduler.PostExecutionSchedulerHolder
import io.reactivex.Observable

/**
 * Created by artemmurashov on 8/29/17.
 */
abstract class NoParamsInteractor<T>(
        executionSchedulerHolder: ExecutionSchedulerHolder,
        postExecutionSchedulerHolder: PostExecutionSchedulerHolder
) : Interactor<T, Any>(executionSchedulerHolder, postExecutionSchedulerHolder) {

    override fun buildObservable(params: Any): Observable<T> = buildObservable()

    abstract protected fun buildObservable(): Observable<T>

    fun execute(
            onNext: (t: T) -> Unit = {},
            onError: (t: Throwable) -> Unit = {},
            onComplete: () -> Unit = {}
    ) {
        super.execute(Any(), onNext, onError, onComplete)
    }
}