package org.murashov.kotlinandroidarchitecture.presentation

import android.app.Application
import org.murashov.kotlinandroidarchitecture.presentation.di.component.ApplicationComponent
import org.murashov.kotlinandroidarchitecture.presentation.di.module.ApplicationModule
import org.murashov.kotlinandroidarchitecture.presentation.di.module.DataModule
import com.squareup.leakcanary.LeakCanary
import com.squareup.leakcanary.RefWatcher
import org.murashov.kotlinandroidarchitecture.presentation.di.component.DaggerApplicationComponent

/**
 * Created by artemmurashov on 8/15/17.
 */
class SampleApplication : Application() {
    companion object {
        @JvmStatic lateinit var applicationComponent: ApplicationComponent private set
        @JvmStatic lateinit var refWatcher: RefWatcher private set
    }

    override fun onCreate() {
        super.onCreate()
        if (LeakCanary.isInAnalyzerProcess(this)) return

        initializeComponent()
        initializeRefWatcher()
    }

    private fun initializeComponent() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .dataModule(DataModule())
                .build()
    }

    private fun initializeRefWatcher() {
        refWatcher = LeakCanary.install(this)
    }
}