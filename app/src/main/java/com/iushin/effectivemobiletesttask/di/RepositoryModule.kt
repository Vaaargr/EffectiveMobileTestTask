package com.iushin.effectivemobiletesttask.di

import com.iushin.data.repositorys.AuthorizationRepositoryImpl
import com.iushin.data.repositorys.GetCurrentUserRepositoryImpl
import com.iushin.data.repositorys.SignOutRepositoryImpl
import com.iushin.domain.api.repositorys.AuthorizationRepository
import com.iushin.domain.api.repositorys.GetCurrentUserNameRepository
import com.iushin.domain.api.repositorys.SignOutRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory <AuthorizationRepository> {
        AuthorizationRepositoryImpl(get())
    }

    factory<SignOutRepository> {
        SignOutRepositoryImpl(get())
    }

    factory<GetCurrentUserNameRepository> {
        GetCurrentUserRepositoryImpl(get())
    }
}