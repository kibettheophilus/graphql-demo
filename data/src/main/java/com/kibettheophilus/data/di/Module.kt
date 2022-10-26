package com.kibettheophilus.data.di

import com.apollographql.apollo3.ApolloClient
import com.kibettheophilus.data.datasource.LaunchListRepositoryImpl
import com.kibettheophilus.data.datasource.LoginRepositoryImpl
import com.kibettheophilus.domain.repository.LaunchListRepository
import com.kibettheophilus.domain.repository.LoginRepository
import org.koin.core.module.Module
import org.koin.dsl.module

val dataModule: Module = module {
    single {
        ApolloClient.Builder().serverUrl("https://apollo-fullstack-tutorial.herokuapp.com/graphql")
            .build()
    }

    single<LaunchListRepository> {
        LaunchListRepositoryImpl(apolloClient = get())
    }
    single<LoginRepository> { LoginRepositoryImpl(apolloClient = get()) }

}
