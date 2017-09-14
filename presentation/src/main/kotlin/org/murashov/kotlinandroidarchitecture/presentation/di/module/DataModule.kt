package org.murashov.kotlinandroidarchitecture.presentation.di.module

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.murashov.kotlinandroidarchitecture.data.datastore.api.ApiDataStore
import org.murashov.kotlinandroidarchitecture.data.datastore.api.UrlProvider
import org.murashov.kotlinandroidarchitecture.data.datastore.api.retrofit.HeaderInterceptor
import org.murashov.kotlinandroidarchitecture.data.datastore.api.retrofit.RestApiService
import org.murashov.kotlinandroidarchitecture.data.datastore.api.retrofit.RetrofitApiDataStore
import org.murashov.kotlinandroidarchitecture.data.datastore.db.DatabaseDataStore
import org.murashov.kotlinandroidarchitecture.data.datastore.db.realm.RealmDataStore
import org.murashov.kotlinandroidarchitecture.data.datastore.image.ImageDataStore
import org.murashov.kotlinandroidarchitecture.data.datastore.image.PicassoImageDataStore
import org.murashov.kotlinandroidarchitecture.data.datastore.preferences.PreferencesDataStore
import org.murashov.kotlinandroidarchitecture.data.datastore.preferences.SharedPreferencesDataStore
import org.murashov.kotlinandroidarchitecture.data.repository.ImageRepository
import org.murashov.kotlinandroidarchitecture.data.repository.ImageRepositoryImpl
import org.murashov.kotlinandroidarchitecture.data.scheduler.ExecutionSchedulerHolderImpl
import org.murashov.kotlinandroidarchitecture.domain.scheduler.ExecutionSchedulerHolder
import org.murashov.kotlinandroidarchitecture.domain.scheduler.PostExecutionSchedulerHolder
import org.murashov.kotlinandroidarchitecture.presentation.scheduler.PostExecutionSchedulerHolderImpl
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by artemmurashov on 8/22/17.
 */
@Module
class DataModule {
    @Provides
    @Singleton
    fun providePreferencesDataStore(
            sharedPreferencesDataStore: SharedPreferencesDataStore
    ): PreferencesDataStore = sharedPreferencesDataStore


    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences
            = PreferenceManager.getDefaultSharedPreferences(context)

    @Provides
    @Singleton
    fun provideOkHttpInterceptor(headerInterceptor: HeaderInterceptor): Interceptor = headerInterceptor

    @Provides
    @Singleton
    fun provideOkHttpClient(interceptor: Interceptor): OkHttpClient
            = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, urlProvider: UrlProvider): Retrofit
            = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(urlProvider.getApiBaseUrl())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    @Provides
    @Singleton
    fun provideRestApiService(retrofit: Retrofit): RestApiService
            = retrofit.create(RestApiService::class.java)

    @Provides
    @Singleton
    fun provideExecutionSchedulerHolder(
            executionSchedulerHolder: ExecutionSchedulerHolderImpl
    ): ExecutionSchedulerHolder = executionSchedulerHolder

    @Provides
    @Singleton
    fun providePostExecutionSchedulerHolder(
            postExecutionSchedulerHolder: PostExecutionSchedulerHolderImpl
    ): PostExecutionSchedulerHolder = postExecutionSchedulerHolder

    @Provides
    @Singleton
    fun provideApiDataStore(remoteDataStore: RetrofitApiDataStore): ApiDataStore = remoteDataStore

    @Provides
    @Singleton
    fun provideImageRepository(imageRepositoryImpl: ImageRepositoryImpl): ImageRepository = imageRepositoryImpl

    @Provides
    @Singleton
    fun provideImageDataStore(imageDataStore: PicassoImageDataStore): ImageDataStore = imageDataStore

    @Provides
    @Singleton
    fun provideDatabaseDataStore(realmDataStore: RealmDataStore): DatabaseDataStore = realmDataStore
}