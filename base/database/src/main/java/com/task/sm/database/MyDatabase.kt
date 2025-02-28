package com.task.sm.database

import androidx.room.withTransaction
import com.task.sm.database.room.RoomDb
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Database implementation using with Room
 */
@Singleton
class MyDatabase @Inject constructor(private val roomDb: RoomDb) : Database {

    override fun clearAllTables() = roomDb.clearAllTables()

    override suspend fun <R> withTransaction(block: suspend () -> R) = roomDb.withTransaction(block)
}
