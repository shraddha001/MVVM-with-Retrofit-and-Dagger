package com.task.sm.database.di

import com.task.sm.database.Database
import com.task.sm.database.daos.PostsDao
import dagger.Subcomponent

@Subcomponent
interface DatabaseSubcomponent {

    val database: Database

    val postsDao: PostsDao
}
