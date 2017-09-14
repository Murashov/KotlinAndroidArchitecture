package org.murashov.kotlinandroidarchitecture.presentation.di.component

import dagger.Component
import org.murashov.kotlinandroidarchitecture.presentation.di.PerFragment
import org.murashov.kotlinandroidarchitecture.presentation.di.module.FragmentModule

/**
 * Created by artemmurashov on 8/31/17.
 */
@PerFragment
@Component(
        modules = arrayOf(FragmentModule::class),
        dependencies = arrayOf(ApplicationComponent::class)
)
interface FragmentComponent {
}