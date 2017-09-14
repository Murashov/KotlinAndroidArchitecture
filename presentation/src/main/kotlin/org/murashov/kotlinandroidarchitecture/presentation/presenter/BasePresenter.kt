package org.murashov.kotlinandroidarchitecture.presentation.presenter

import android.arch.lifecycle.LifecycleRegistryOwner
import android.arch.lifecycle.ViewModel
import android.support.annotation.CallSuper
import org.murashov.kotlinandroidarchitecture.presentation.SampleApplication
import org.murashov.kotlinandroidarchitecture.presentation.view.MvpView

/**
 * Created by artemmurashov on 8/31/17.
 */
abstract class BasePresenter<T : MvpView> : ViewModel(), MvpPresenter<T> {
    protected var view: T? = null
        private set

    protected val tag: String = javaClass.simpleName
    protected var isInitialized = false

    final override fun attachView(view: T) {
        this.view = view

        if (view is LifecycleRegistryOwner) {
            view.lifecycle.addObserver(this)
        }

        onAttach(view)
    }

    final override fun detachView() {
        val view = view

        if (view is LifecycleRegistryOwner) {
            view.lifecycle.removeObserver(this)
        }

        this.view = null

        onDetach()
    }

    @CallSuper
    override fun onCleared() {
        super.onCleared()
        SampleApplication.refWatcher.watch(this)
    }

    override fun onResume() {}
    override fun onPause() {}

    open protected fun onAttach(view: T) {}
    open protected fun onDetach() {}
}