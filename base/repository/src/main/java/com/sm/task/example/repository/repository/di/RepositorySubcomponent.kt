package com.sm.task.example.repository.repository.di

import com.sm.task.example.repository.repository.MyRepository
import dagger.Subcomponent

@Subcomponent
interface RepositorySubcomponent {
    val myRepository: MyRepository
}
