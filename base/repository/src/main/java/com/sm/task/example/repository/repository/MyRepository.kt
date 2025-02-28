package com.sm.task.example.repository.repository

import com.sm.task.example.api.retrofit.ApiErrorResponse
import com.sm.task.example.api.retrofit.ApiNetworkError
import com.sm.task.example.api.retrofit.ApiSuccessResponse
import com.sm.task.example.api.retrofit.ApiTimeoutError
import com.sm.task.example.repository.repository.api.RemoteDataSourceProvider
import com.sm.task.example.repository.repository.convertor.toPostResult
import com.sm.task.example.repository.repository.convertor.toPosts
import com.sm.task.example.repository.repository.model.PostsResult
import com.sm.task.example.repository.repository.resource.NetworkError
import com.sm.task.example.repository.repository.resource.Resource
import com.task.sm.database.daos.PostsDao
import com.task.sm.database.entities.PostsEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyRepository @Inject constructor(
    remoteDataSourceProvider: RemoteDataSourceProvider,
    private val postsDao: PostsDao,
) {
    private var apiService = remoteDataSourceProvider.apiService

    suspend fun getPosts(): Resource<PostsResult> {
        val list: ArrayList<PostsEntity> = arrayListOf()
        return when (val response = apiService.getPosts(0, 20)) {
            is ApiSuccessResponse -> {
                response.body.posts.forEach {
                    list.add(PostsEntity(id = it.id, body = it.body, title = it.title))
                }
                postsDao.insertOrReplace(list)
                Resource.success(response.body.toPostResult())
            }
            is ApiTimeoutError -> Resource.error(null, networkError = NetworkError.TIMEOUT)
            is ApiErrorResponse -> Resource.error(null, response.errorMessage)
            is ApiNetworkError -> Resource.error(null)
            else -> Resource.error(null)
        }
    }
}