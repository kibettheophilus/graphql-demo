package com.kibettheophilus.domain

data class LaunchDataDomain(
    val launches: Launches
)

data class Launches(
    val cursor: String
)