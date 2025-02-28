package com.sm.task.example.api.interceptors

interface HeaderFactory {
    fun getAuthHeaders(host: String): List<Pair<String, String>>
}
