package com.kibettheophilus.graphql

import com.kibettheophilus.feature.LaunchListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module {
    viewModel { LaunchListViewModel(get()) }
}