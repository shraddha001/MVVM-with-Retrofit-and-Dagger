package com.example.mvvmwithdagger.repository

import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.mvvmwithdagger.TokenDto
import com.example.mvvmwithdagger.api.retrofit.ApiErrorResponse
import com.example.mvvmwithdagger.api.retrofit.ApiNetworkError
import com.example.mvvmwithdagger.api.retrofit.ApiSuccessResponse
import com.example.mvvmwithdagger.api.retrofit.ApiTimeoutError
import com.example.mvvmwithdagger.repository.api.RemoteDataSourceProvider
import com.example.mvvmwithdagger.resource.NetworkError
import com.example.mvvmwithdagger.resource.Resource
import okhttp3.FormBody
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyRepository @Inject constructor(
    remoteDataSourceProvider: RemoteDataSourceProvider,
    val sharedPref: SharedPreferences
) {
    private var apiService = remoteDataSourceProvider.apiService
    suspend fun token(): Resource<TokenDto> {
        val requestBody = FormBody.Builder()
            .add("grant_type", "client_credentials")
            .add("client_id", "0013fadfa3694cb5b978b7bfb10a9ea3")
            .add("client_secret", "3761dccf50444745a64f4c1c10de09bc")
            .build()
        return when (val response = apiService.token(requestBody)) {
            is ApiSuccessResponse -> {
                sharedPref.edit {
                    putString(CLIENT_SECRET, response.body.access_token)
                }
                Resource.success(response.body)
            }

            is ApiTimeoutError -> Resource.error(null, networkError = NetworkError.TIMEOUT)
            is ApiErrorResponse -> Resource.error(null, response.errorMessage)
            is ApiNetworkError -> Resource.error(null)
            else -> Resource.error(null)
        }
    }

    fun getClientSecret(): String {
        return sharedPref.getString(CLIENT_SECRET, "") ?: ""
    }

    companion object {
        private val CLIENT_SECRET = "client_secret"
    }
}