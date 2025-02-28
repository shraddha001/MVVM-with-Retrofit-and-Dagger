package com.task.sm.database.di

import android.app.Application
import androidx.room.Room
import com.task.sm.database.room.RoomDb
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal object DaoModule {

    @Singleton
    @Provides
    fun provideRoomDb(app: Application) =
        Room.databaseBuilder(app, RoomDb::class.java, "MyDb.db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun providePostsDao(db: RoomDb) = db.postsDao()
}
