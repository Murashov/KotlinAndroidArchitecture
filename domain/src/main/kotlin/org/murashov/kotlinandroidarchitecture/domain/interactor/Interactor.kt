package org.murashov.kotlinandroidarchitecture.domain.interactor

import org.murashov.kotlinandroidarchitecture.domain.scheduler.ExecutionSchedulerHolder
import org.murashov.kotlinandroidarchitecture.domain.scheduler.PostExecutionSchedulerHolder
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable


/**
 * Created by artemmurashov on 8/17/17.
 */
abstract class Interactor<T, in P>(
        private val executionSchedulerHolder: ExecutionSchedulerHolder,
        private val postExecutionSchedulerHolder: PostExecutionSchedulerHolder
) {
    private val disposables: CompositeDisposable = CompositeDisposable()

    abstract protected fun buildObservable(params: P): Observable<T>

    fun execute(params: P,
                onNext: (t: T) -> Unit = {},
                onError: (t: Throwable) -> Unit = {},
                onComplete: () -> Unit = {}) {
        val observable = buildObservable(params)
                .subscribeOn(executionSchedulerHolder.scheduler)
                .observeOn(postExecutionSchedulerHolder.scheduler)

        disposables.add(observable.subscribe(onNext, onError, onComplete))
    }

    fun dispose() = disposables.dispose()
}