package com.task.sm.database.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DatabaseModule::class])
interface DatabaseComponent {
    val databaseSubcomponent: DatabaseSubcomponent

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): DatabaseComponent
    }

    companion object {
        fun createDatabaseComponent(app: Application): DatabaseSubcomponent =
            DaggerDatabaseComponent.factory().create(app).databaseSubcomponent
    }
}
