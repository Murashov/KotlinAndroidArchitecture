package org.murashov.kotlinandroidarchitecture.presentation.di.component

import android.content.Context
import dagger.Component
import org.murashov.kotlinandroidarchitecture.data.repository.ImageRepository
import org.murashov.kotlinandroidarchitecture.domain.scheduler.ExecutionSchedulerHolder
import org.murashov.kotlinandroidarchitecture.domain.scheduler.PostExecutionSchedulerHolder
import org.murashov.kotlinandroidarchitecture.presentation.di.module.ApplicationModule
import org.murashov.kotlinandroidarchitecture.presentation.di.module.DataModule
import org.murashov.kotlinandroidarchitecture.presentation.di.module.NavigationModule
import org.murashov.kotlinandroidarchitecture.presentation.helpers.ImageLoader
import org.murashov.kotlinandroidarchitecture.presentation.navigation.FragmentFactory
import org.murashov.kotlinandroidarchitecture.presentation.view.activity.BaseActivity
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

/**
 * Created by artemmurashov on 8/17/17.
 */
@Singleton
@Component(
        modules = arrayOf(
                ApplicationModule::class,
                NavigationModule::class,
                DataModule::class
        )
)
interface ApplicationComponent {
    fun inject(baseActivity: BaseActivity)

    val navigationHolder: NavigatorHolder
    val router: Router
    val imageRepository: ImageRepository
    val executionSchedulerHolder: ExecutionSchedulerHolder
    val postExecutionSchedulerHolder: PostExecutionSchedulerHolder
    val context: Context
    val fragmentFactory: FragmentFactory
    val imageLoader: ImageLoader
}