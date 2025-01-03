package com.example.mvvmwithdagger

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TokenDto(
    val access_token: String?,
    val token_type: String?,
    val expires_in: Long?
)