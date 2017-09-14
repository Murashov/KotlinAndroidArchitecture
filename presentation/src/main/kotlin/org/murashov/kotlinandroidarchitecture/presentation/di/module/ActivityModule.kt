package org.murashov.kotlinandroidarchitecture.presentation.di.module

import dagger.Module
import dagger.Provides
import org.murashov.kotlinandroidarchitecture.presentation.di.PerActivity
import org.murashov.kotlinandroidarchitecture.presentation.view.activity.BaseActivity

/**
 * Created by artemmurashov on 8/25/17.
 */
@Module
class ActivityModule(private val activity: BaseActivity) {
    @Provides
    @PerActivity
    fun provideBaseActivity(): BaseActivity = activity
}