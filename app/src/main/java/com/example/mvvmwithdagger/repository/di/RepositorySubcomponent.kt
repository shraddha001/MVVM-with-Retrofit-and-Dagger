package com.example.mvvmwithdagger.repository.di

import com.example.mvvmwithdagger.repository.MyRepository
import dagger.Subcomponent

@Subcomponent
interface RepositorySubcomponent {
    val myRepository: MyRepository
}
