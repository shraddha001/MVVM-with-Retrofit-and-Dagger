package com.sm.task.example.api.retrofit

import com.sm.task.example.api.dto.PostsResultDto
import retrofit2.http.GET
import retrofit2.http.Query

internal interface ApiServiceImpl : ApiService {
    @GET("/posts")
    override suspend fun getPosts(
        @Query("skip") skip: Int,
        @Query("limit") limit: Int
    ): ApiResponse<PostsResultDto>
}
