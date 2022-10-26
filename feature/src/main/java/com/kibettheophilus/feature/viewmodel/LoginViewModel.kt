package com.kibettheophilus.feature.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kibettheophilus.domain.LaunchDataDomain
import com.kibettheophilus.domain.repository.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: LoginRepository):ViewModel() {
    private val _token = MutableLiveData<String>()
    val token: LiveData<String> = _token

    init {
        loginUser()
    }
    private fun loginUser() {
        viewModelScope.launch {
            val result = repository.loginUser("theo@gmail.com")
            _token.value = result.token
            Log.d("DATAGRQV", "$result")
        }
    }
}