package com.kibettheophilus.feature.di

import com.kibettheophilus.feature.viewmodel.LaunchListViewModel
import com.kibettheophilus.feature.viewmodel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val featureModule: Module = module {
    viewModel { LaunchListViewModel(repository = get()) }
    viewModel { LoginViewModel(repository = get()) }
}