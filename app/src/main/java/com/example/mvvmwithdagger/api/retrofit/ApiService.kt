package com.example.mvvmwithdagger.api.retrofit

import com.example.mvvmwithdagger.TokenDto
import okhttp3.FormBody

/**
 * REST API access points
 */
interface ApiService {
    suspend fun token(body: FormBody): ApiResponse<TokenDto>

}
