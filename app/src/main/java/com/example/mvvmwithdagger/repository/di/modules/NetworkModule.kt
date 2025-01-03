package com.example.mvvmwithdagger.repository.di.modules

import com.example.mvvmwithdagger.api.interceptors.HeaderFactory
import com.example.mvvmwithdagger.repository.api.MyRemoteDataSourceProvider
import com.example.mvvmwithdagger.repository.api.RemoteDataSourceProvider
import com.example.mvvmwithdagger.repository.api.interceptors.AuthorizationHeaderFactory
import com.example.mvvmwithdagger.repository.di.api.ApiServiceSubcomponent
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
