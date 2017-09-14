package org.murashov.kotlinandroidarchitecture.presentation.view.fragment

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.murashov.kotlinandroidarchitecture.presentation.SampleApplication
import org.murashov.kotlinandroidarchitecture.presentation.di.component.DaggerFragmentComponent
import org.murashov.kotlinandroidarchitecture.presentation.di.component.FragmentComponent
import org.murashov.kotlinandroidarchitecture.presentation.di.module.FragmentModule
import org.murashov.kotlinandroidarchitecture.presentation.view.activity.BaseActivity

/**
 * Created by artemmurashov on 8/25/17.
 */
abstract class BaseFragment : Fragment(), LifecycleRegistryOwner {
    private val lifecycleRegistry = LifecycleRegistry(this)

    protected lateinit var baseActivity: BaseActivity
    protected lateinit var fragmentComponent: FragmentComponent

    abstract protected val layoutId: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseActivity = activity as BaseActivity
        initComponent()
    }

    override fun onDestroy() {
        super.onDestroy()
        SampleApplication.refWatcher.watch(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(layoutId, container, false)
    }

    private fun initComponent() {
        fragmentComponent = DaggerFragmentComponent.builder()
                .applicationComponent(SampleApplication.applicationComponent)
                .fragmentModule(FragmentModule(this))
                .build()
    }

    override fun getLifecycle() = lifecycleRegistry
}