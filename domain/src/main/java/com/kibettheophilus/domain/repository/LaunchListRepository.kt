package com.kibettheophilus.domain.repository

import com.kibettheophilus.domain.models.LaunchDataDomain

interface LaunchListRepository {
    suspend fun launchList(): LaunchDataDomain
}