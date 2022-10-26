package com.kibettheophilus.data.di

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.network.http.LoggingInterceptor
import com.apollographql.apollo3.network.okHttpClient
import com.kibettheophilus.data.datasource.LaunchListRepositoryImpl
import com.kibettheophilus.data.datasource.LoginRepositoryImpl
import com.kibettheophilus.data.interceptor.AuthApolloInterceptor
import com.kibettheophilus.data.interceptor.AuthHttpInterceptor
import com.kibettheophilus.data.interceptor.AuthorizationInterceptor
import com.kibettheophilus.domain.repository.LaunchListRepository
import com.kibettheophilus.domain.repository.LoginRepository
import okhttp3.OkHttpClient
import org.koin.core.module.Module
import org.koin.dsl.module

val dataModule: Module = module {
    single { provideApolloClient(okHttpClient = get()) }
    single { provideOkhttpClient() }

    single<LaunchListRepository> { LaunchListRepositoryImpl(apolloClient = get()) }
    single<LoginRepository> { LoginRepositoryImpl(apolloClient = get()) }

}

private fun provideApolloClient(okHttpClient: OkHttpClient): ApolloClient {
    return ApolloClient.Builder()
        .serverUrl("https://apollo-fullstack-tutorial.herokuapp.com/graphql")
        .addHttpInterceptor(LoggingInterceptor())
        .okHttpClient(okHttpClient)
        .addHttpInterceptor(AuthHttpInterceptor())
        .addInterceptor(AuthApolloInterceptor())
        .build()
}

private fun provideOkhttpClient(): OkHttpClient {
    return OkHttpClient.Builder().addInterceptor(AuthorizationInterceptor()).build()
}
