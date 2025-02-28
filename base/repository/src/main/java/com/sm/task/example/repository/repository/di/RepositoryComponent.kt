package com.sm.task.example.repository.repository.di

import android.app.Application
import com.sm.task.example.repository.repository.di.modules.MainModule
import com.sm.task.example.repository.repository.di.modules.NetworkModule
import com.sm.task.example.repository.repository.di.modules.PreferencesModule
import com.task.sm.database.di.DatabaseComponent
import com.task.sm.database.di.DatabaseSubcomponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [MainModule::class, PreferencesModule::class, NetworkModule::class],
    dependencies = [DatabaseSubcomponent::class]
)
interface RepositoryComponent {

    val repositorySubcomponent: RepositorySubcomponent

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance app: Application,
            databaseSubcomponent: DatabaseSubcomponent
        ): RepositoryComponent
    }

    companion object {
        fun create(
            app: Application
        ): RepositorySubcomponent = DaggerRepositoryComponent.factory()
            .create(app, DatabaseComponent.createDatabaseComponent(app)).repositorySubcomponent
    }
}
