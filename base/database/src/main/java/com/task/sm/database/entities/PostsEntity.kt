package com.task.sm.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Posts")
data class PostsEntity (
    @PrimaryKey
    val id: Int?,
    val title: String?,
    val body: String?,
)