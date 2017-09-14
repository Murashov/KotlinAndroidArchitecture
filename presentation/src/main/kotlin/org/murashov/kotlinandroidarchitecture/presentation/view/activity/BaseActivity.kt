package org.murashov.kotlinandroidarchitecture.presentation.view.activity

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.murashov.kotlinandroidarchitecture.presentation.SampleApplication
import org.murashov.kotlinandroidarchitecture.presentation.di.component.ActivityComponent
import org.murashov.kotlinandroidarchitecture.presentation.di.component.DaggerActivityComponent
import org.murashov.kotlinandroidarchitecture.presentation.di.module.ActivityModule
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

/**
 * Created by artemmurashov on 8/17/17.
 */
abstract class BaseActivity : AppCompatActivity(), LifecycleRegistryOwner {
    private val lifecycleRegistry = LifecycleRegistry(this)

    @Inject
    lateinit var navigationHolder: NavigatorHolder

    protected var navigator: Navigator? = null

    abstract protected val layoutId: Int

    abstract val fragmentContainerId: Int

    lateinit var activityComponent: ActivityComponent private set

    override fun onCreate(savedInstanceState: Bundle?) {
        initComponent() // Should be initialized before calling super
        super.onCreate(savedInstanceState)

        setContentView(layoutId)
        SampleApplication.applicationComponent.inject(this)
    }

    private fun initComponent() {
        activityComponent = DaggerActivityComponent.builder()
                .applicationComponent(SampleApplication.applicationComponent)
                .activityModule(ActivityModule(this))
                .build()
    }

    override fun onResume() {
        super.onResume()
        if (navigator != null) {
            navigationHolder.setNavigator(navigator)
        }
    }

    override fun onPause() {
        super.onPause()
        navigationHolder.removeNavigator()
    }

    override fun getLifecycle() = lifecycleRegistry
}