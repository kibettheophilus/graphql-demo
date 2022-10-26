package com.kibettheophilus.data.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val token = "kjewffffbdjagdfy"

        val request =
            chain.request().newBuilder().addHeader("Authorization", "Bearer $token").build()
        return chain.proceed(request)
    }
}