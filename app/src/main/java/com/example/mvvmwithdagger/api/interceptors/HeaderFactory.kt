package com.example.mvvmwithdagger.api.interceptors

interface HeaderFactory {
    fun getAuthHeaders(host: String): List<Pair<String, String>>
}
