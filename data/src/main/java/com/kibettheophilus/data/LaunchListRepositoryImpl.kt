package com.kibettheophilus.data

import com.apollographql.apollo3.ApolloClient
import com.kibettheophilus.domain.LaunchDataDomain
import com.kibettheophilus.domain.LaunchListRepository
import toDomain

class LaunchListRepositoryImpl(private val apolloClient: ApolloClient) : LaunchListRepository {
    override suspend fun launchList(): LaunchDataDomain {
        val response = apolloClient.query(LaunchListQuery()).execute()
        return response.data!!.toDomain()
    }
}