package com.example.mvvmwithdagger

import android.app.Application
import com.example.mvvmwithdagger.di.AppComponent
import com.example.mvvmwithdagger.di.CoreDependencyInjectionHolder
import com.example.mvvmwithdagger.di.DaggerAppComponent

class MyApp : Application(), CoreDependencyInjectionHolder {

    override val coreComponent: AppComponent by lazy {
        DaggerAppComponent.factory()
            .create(
                app = this,
                repositorySubcomponent = com.sm.task.example.repository.repository.di.RepositoryComponent.create(
                    this
                )
            )
    }
}