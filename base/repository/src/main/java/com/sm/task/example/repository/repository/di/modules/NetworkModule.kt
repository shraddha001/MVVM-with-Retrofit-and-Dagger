package com.sm.task.example.repository.repository.di.modules

import com.sm.task.example.api.interceptors.HeaderFactory
import com.sm.task.example.repository.repository.api.MyRemoteDataSourceProvider
import com.sm.task.example.repository.repository.api.RemoteDataSourceProvider
import com.sm.task.example.repository.repository.api.interceptors.AuthorizationHeaderFactory
import com.sm.task.example.repository.repository.di.api.ApiServiceSubcomponent
import dagger.Binds
import dagger.Module

@Module(subcomponents = [ApiServiceSubcomponent::class])
internal abstract class NetworkModule {
    @Binds
    abstract fun provideHeaderFactory(headerFactory: AuthorizationHeaderFactory): HeaderFactory

    @Binds
    abstract fun provideRemoteDataSourceProvider(
        teRemoteDataSourceProvider: MyRemoteDataSourceProvider
    ): RemoteDataSourceProvider

}
