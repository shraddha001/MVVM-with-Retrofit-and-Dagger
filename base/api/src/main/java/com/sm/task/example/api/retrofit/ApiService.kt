package com.sm.task.example.api.retrofit

import com.sm.task.example.api.dto.PostsResultDto

/**
 * REST API access points
 */
interface ApiService {
    suspend fun getPosts(skip: Int, limit: Int): ApiResponse<PostsResultDto>
}
