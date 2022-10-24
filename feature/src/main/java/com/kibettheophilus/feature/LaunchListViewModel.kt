package com.kibettheophilus.feature

import android.util.Log
import androidx.lifecycle.ViewModel
import com.kibettheophilus.domain.LaunchDataDomain
import com.kibettheophilus.domain.LaunchListRepository

class LaunchListViewModel(private val repository: LaunchListRepository) : ViewModel() {
    suspend fun launchList(): LaunchDataDomain {
        val result = repository.launchList()
        Log.d("DATAGRQV", "$result")
        return result
    }
}