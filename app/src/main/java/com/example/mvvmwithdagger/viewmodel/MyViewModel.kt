package com.example.mvvmwithdagger.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sm.task.example.repository.repository.MyRepository
import com.sm.task.example.repository.repository.model.PostsResult
import com.sm.task.example.repository.repository.resource.NetworkError
import com.sm.task.example.repository.repository.resource.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

class MyViewModel @Inject constructor(
    private val repository: MyRepository
) : ViewModel() {
    private var postState = MutableLiveData<Resource<PostsResult>>()

    fun getPostState() = postState

    var isOffline = false

    fun getPosts() {
        if (isOffline) {
            // No network connection
            postState.value = Resource.error(
                data = null,
                networkError = NetworkError.NO_CONNECTIVITY
            )
            return
        }
        postState.value = Resource.loading(data = null)
        viewModelScope.launch {
            val resource = repository.getPosts()
            postState.postValue(resource)
        }
    }
}