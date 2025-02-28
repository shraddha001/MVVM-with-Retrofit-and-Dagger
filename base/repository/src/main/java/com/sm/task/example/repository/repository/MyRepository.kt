package com.sm.task.example.repository.repository

import com.sm.task.example.api.retrofit.ApiErrorResponse
import com.sm.task.example.api.retrofit.ApiNetworkError
import com.sm.task.example.api.retrofit.ApiSuccessResponse
import com.sm.task.example.api.retrofit.ApiTimeoutError
import com.sm.task.example.repository.repository.api.RemoteDataSourceProvider
import com.sm.task.example.repository.repository.convertor.toPostResult
import com.sm.task.example.repository.repository.model.PostsResult
import com.sm.task.example.repository.repository.resource.NetworkError
import com.sm.task.example.repository.repository.resource.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyRepository @Inject constructor(
    remoteDataSourceProvider: RemoteDataSourceProvider
) {
    private var apiService = remoteDataSourceProvider.apiService

    suspend fun getPosts(): Resource<PostsResult> {
        return when (val response = apiService.getPosts(0, 20)) {
            is ApiSuccessResponse ->  Resource.success(response.body.toPostResult())
            is ApiTimeoutError -> Resource.error(null, networkError = NetworkError.TIMEOUT)
            is ApiErrorResponse -> Resource.error(null, response.errorMessage)
            is ApiNetworkError -> Resource.error(null)
            else -> Resource.error(null)
        }
    }
}