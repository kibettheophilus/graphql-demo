package com.kibettheophilus.domain.repository

import com.kibettheophilus.domain.models.TokenDataDomain

interface LoginRepository {
    suspend fun loginUser(email: String): TokenDataDomain
}