package com.hpcreation.bandhanmarry.di

import com.hpcreation.bandhanmarry.presentation.viewmodel.HomeViewModel
import com.hpcreation.bandhanmarry.presentation.viewmodel.LoginViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { LoginViewModel() }
    viewModel { HomeViewModel() }
}