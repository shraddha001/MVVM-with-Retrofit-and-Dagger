package com.task.sm.database.daos

import androidx.room.Dao
import androidx.room.Query
import com.task.sm.database.entities.PostsEntity

@Dao
abstract class PostsDao : BaseDao<PostsEntity> {
    /**
     * Returns a list of cart
     */
    @Query("SELECT * FROM Posts")
    abstract suspend fun getCarts(): List<PostsEntity>

    @Query("DELETE FROM Posts")
    abstract suspend fun deleteAll()
}
