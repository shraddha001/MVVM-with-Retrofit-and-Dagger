package com.task.sm.database.di

import com.task.sm.database.Database
import com.task.sm.database.MyDatabase
import dagger.Binds
import dagger.Module

@Module(includes = [DaoModule::class])
internal abstract class DatabaseModule {

    @Binds
    abstract fun provideDatabase(myDatabase: MyDatabase): Database
}
