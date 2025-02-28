package com.task.sm.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.task.sm.database.daos.PostsDao
import com.task.sm.database.entities.PostsEntity

/**
 * Room database implementation.
 */

@Database(entities = [PostsEntity::class], version = 1)

abstract class RoomDb(): RoomDatabase() {

    abstract fun postsDao(): PostsDao
}