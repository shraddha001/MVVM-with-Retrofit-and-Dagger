package com.example.mvvmwithdagger.repository.di

import android.app.Application
import com.example.mvvmwithdagger.repository.di.modules.MainModule
import com.example.mvvmwithdagger.repository.di.modules.NetworkModule
import com.example.mvvmwithdagger.repository.di.modules.PreferencesModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [MainModule::class, PreferencesModule::class, NetworkModule::class]
)
interface RepositoryComponent {

    val repositorySubcomponent: RepositorySubcomponent

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance app: Application,
        ): RepositoryComponent
    }

    companion object {
        fun create(
            app: Application
        ): RepositorySubcomponent = DaggerRepositoryComponent.factory()
            .create(app).repositorySubcomponent
    }
}
