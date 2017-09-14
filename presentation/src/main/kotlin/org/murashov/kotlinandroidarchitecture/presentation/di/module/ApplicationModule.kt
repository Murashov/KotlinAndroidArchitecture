package org.murashov.kotlinandroidarchitecture.presentation.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by artemmurashov on 8/17/17.
 */
@Module
class ApplicationModule(private val application: Application) {
    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application
}