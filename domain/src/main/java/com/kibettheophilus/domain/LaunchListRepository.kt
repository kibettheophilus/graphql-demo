package com.kibettheophilus.domain

interface LaunchListRepository {
    suspend fun launchList(): LaunchDataDomain
}