package com.kibettheophilus.data.datasource

import android.util.Log
import com.apollographql.apollo3.ApolloClient
import com.kibettheophilus.data.LoginMutation
import com.kibettheophilus.domain.models.TokenDataDomain
import com.kibettheophilus.domain.repository.LoginRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import toDomain

class LoginRepositoryImpl(private val apolloClient: ApolloClient) : LoginRepository {
    override suspend fun loginUser(email: String): TokenDataDomain {
        val response = apolloClient.mutation(LoginMutation(email)).execute()
        Log.d("DATAGRAQL", "${response.data?.login}")
        return response.data?.login!!.toDomain()
    }
}