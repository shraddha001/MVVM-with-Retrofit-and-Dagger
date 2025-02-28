package com.sm.task.example.repository.repository.di.api

import com.sm.task.example.api.di.ApiServiceFactory
import com.sm.task.example.api.interceptors.HeaderFactory
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
