package com.example.mvvmwithdagger.di

import android.app.Activity
import android.app.Application
import com.example.mvvmwithdagger.MainActivity
import com.example.mvvmwithdagger.di.modules.AppModule
import com.sm.task.example.repository.repository.di.RepositorySubcomponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AppModule::class],
    dependencies = [com.sm.task.example.repository.repository.di.RepositorySubcomponent::class]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance app: Application,
            repositorySubcomponent: com.sm.task.example.repository.repository.di.RepositorySubcomponent
        ): AppComponent
    }
}

fun MainActivity.appComponent() = coreComponent() as AppComponent

fun Activity.coreComponent() = (applicationContext as CoreDependencyInjectionHolder).coreComponent

interface CoreComponent

interface CoreDependencyInjectionHolder {
    val coreComponent: AppComponent
}
