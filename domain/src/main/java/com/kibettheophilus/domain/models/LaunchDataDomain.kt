package com.kibettheophilus.domain.models

data class LaunchDataDomain(
    val launches: Launches
)

data class Launches(
    val cursor: String
)