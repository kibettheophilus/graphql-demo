package com.kibettheophilus.data.interceptor

import com.apollographql.apollo3.api.http.HttpRequest
import com.apollographql.apollo3.api.http.HttpResponse
import com.apollographql.apollo3.network.http.HttpInterceptor
import com.apollographql.apollo3.network.http.HttpInterceptorChain

class AuthHttpInterceptor : HttpInterceptor {
    override suspend fun intercept(
        request: HttpRequest,
        chain: HttpInterceptorChain
    ): HttpResponse {
        val token = "jsgayyukjdakjdga"

        return chain.proceed(
            request.newBuilder().addHeader("Authorization", "Bearer $token").build()
        )
    }

}