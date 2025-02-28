package com.task.sm.database.daos

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Update

internal interface BaseDao<T> {

    @Insert(onConflict = IGNORE)
    suspend fun insert(obj: T): Long

    @Update
    suspend fun update(obj: T): Int

    @Insert(onConflict = REPLACE)
    suspend fun insertOrReplace(list: List<T>)

    @Delete
    suspend fun delete(list: List<T>): Int
}
