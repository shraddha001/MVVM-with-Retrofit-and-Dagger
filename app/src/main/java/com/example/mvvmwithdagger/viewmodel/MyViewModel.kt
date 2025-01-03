package com.example.mvvmwithdagger.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmwithdagger.TokenDto
import com.example.mvvmwithdagger.repository.MyRepository
import com.example.mvvmwithdagger.resource.NetworkError
import com.example.mvvmwithdagger.resource.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

class MyViewModel @Inject constructor(
    val repository: MyRepository
) : ViewModel() {
    var tokenState = MutableLiveData<Resource<TokenDto>>()

    fun tokenState() = tokenState

    var isOffline = false

    fun token() {
        if (isOffline) {
            // No network connection
            tokenState.value = Resource.error(
                data = null,
                networkError = NetworkError.NO_CONNECTIVITY
            )
            return
        }
        tokenState.value = Resource.loading(data = null)
        viewModelScope.launch {
            val resource = repository.token()
            tokenState.postValue(resource)
        }
    }

    fun getClientSecret(): String = repository.getClientSecret()

    fun resetTokenState() {
        tokenState = MutableLiveData<Resource<TokenDto>>()
    }
}