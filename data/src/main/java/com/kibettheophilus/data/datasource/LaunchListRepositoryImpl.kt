package com.kibettheophilus.data.datasource

import android.util.Log
import com.apollographql.apollo3.ApolloClient
import com.kibettheophilus.data.LaunchListQuery
import com.kibettheophilus.domain.LaunchDataDomain
import com.kibettheophilus.domain.repository.LaunchListRepository
import toDomain

class LaunchListRepositoryImpl(private val apolloClient: ApolloClient) : LaunchListRepository {
    override suspend fun launchList(): LaunchDataDomain {
        val response = apolloClient.query(LaunchListQuery()).execute()
        Log.d("DATAGRQR", "${response.data}")
        return response.data!!.toDomain()
    }
}