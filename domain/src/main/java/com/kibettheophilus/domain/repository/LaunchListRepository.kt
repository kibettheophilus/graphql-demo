package com.kibettheophilus.domain.repository

import com.kibettheophilus.domain.LaunchDataDomain

interface LaunchListRepository {
    suspend fun launchList(): LaunchDataDomain
}