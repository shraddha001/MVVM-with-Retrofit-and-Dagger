package com.sm.task.example.repository.repository.di.api

import com.sm.task.example.api.retrofit.ApiService
import dagger.Subcomponent

@NetworkScope
@Subcomponent(modules = [ApiServiceModule::class])
interface ApiServiceSubcomponent {
    val apiService: ApiService

    @Subcomponent.Factory
    interface Factory {
        fun create(): ApiServiceSubcomponent
    }
}
