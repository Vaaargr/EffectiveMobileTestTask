package com.iushin.effectivemobiletesttask.di

import com.iushin.effectivemobiletesttask.presentation.viewModel.AuthorizationViewModel
import com.iushin.effectivemobiletesttask.presentation.viewModel.MainActivityViewModel
import com.iushin.effectivemobiletesttask.presentation.viewModel.MainFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        AuthorizationViewModel(get())
    }

    viewModel{
        MainActivityViewModel(get())
    }

    viewModel {
        MainFragmentViewModel(get())
    }
}