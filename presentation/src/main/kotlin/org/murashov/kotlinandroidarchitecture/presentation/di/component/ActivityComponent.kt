package org.murashov.kotlinandroidarchitecture.presentation.di.component

import dagger.Component
import org.murashov.kotlinandroidarchitecture.presentation.di.PerActivity
import org.murashov.kotlinandroidarchitecture.presentation.di.module.ActivityModule

/**
 * Created by artemmurashov on 8/25/17.
 */
@PerActivity
@Component(
        dependencies = arrayOf(ApplicationComponent::class),
        modules = arrayOf(ActivityModule::class)
)
interface ActivityComponent {
}