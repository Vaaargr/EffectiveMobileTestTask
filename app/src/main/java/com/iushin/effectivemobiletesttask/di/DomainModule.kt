package com.iushin.effectivemobiletesttask.di

import com.iushin.domain.api.interactors.AuthorizationInteractor
import com.iushin.domain.impl.AuthorizationInteractorImpl
import com.iushin.domain.impl.GetCurrentUserNameUseCase
import com.iushin.domain.impl.SignOutUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<AuthorizationInteractor> {
        AuthorizationInteractorImpl(get())
    }

    factory<SignOutUseCase> {
        SignOutUseCase(get())
    }

    factory { GetCurrentUserNameUseCase(get()) }
}