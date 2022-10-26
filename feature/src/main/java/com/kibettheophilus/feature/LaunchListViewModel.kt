package com.kibettheophilus.feature

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kibettheophilus.domain.LaunchDataDomain
import com.kibettheophilus.domain.repository.LaunchListRepository
import kotlinx.coroutines.launch

class LaunchListViewModel(private val repository: LaunchListRepository) : ViewModel() {
    private val _launchList = MutableLiveData<LaunchDataDomain>()
    val launchList: LiveData<LaunchDataDomain> = _launchList

    init {
        launchList()
    }
    private fun launchList() {
        viewModelScope.launch {
            val result = repository.launchList()
            _launchList.value = result
            Log.d("DATAGRQV", "$result")
        }
    }
}