package com.example.mvvmwithdagger.repository.di.api

import com.example.mvvmwithdagger.api.di.ApiServiceFactory
import com.example.mvvmwithdagger.api.interceptors.HeaderFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides

@Module
object ApiServiceModule {
    @NetworkScope
    @Provides
    fun provideApiService(
        headerFactory: HeaderFactory,
        moshi: Moshi,
    ) = ApiServiceFactory.createApiService(
        headerFactory,
        moshi
    )
}
