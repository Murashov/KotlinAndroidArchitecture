package org.murashov.kotlinandroidarchitecture.presentation.presenter

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import org.murashov.kotlinandroidarchitecture.presentation.view.MvpView

/**
 * Created by artemmurashov on 8/25/17.
 */
interface MvpPresenter<in T : MvpView> : LifecycleObserver {
    fun attachView(view: T)
    fun detachView()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume()

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause()
}