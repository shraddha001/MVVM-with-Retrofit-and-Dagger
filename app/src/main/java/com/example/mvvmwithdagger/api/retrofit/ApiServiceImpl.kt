package com.example.mvvmwithdagger.api.retrofit

import com.example.mvvmwithdagger.TokenDto
import okhttp3.FormBody
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

internal interface ApiServiceImpl : ApiService {
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("api/token")
    override suspend fun token(
        @Body body: FormBody
    ): ApiResponse<TokenDto>
}
