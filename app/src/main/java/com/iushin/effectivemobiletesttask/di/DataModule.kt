package com.iushin.effectivemobiletesttask.di

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.iushin.data.clientInterfaces.AuthorizationClient
import com.iushin.data.clientInterfaces.GetCurrentUserNameClient
import com.iushin.data.clientInterfaces.SignOutClient
import com.iushin.data.clients.AuthorizationClientImpl
import com.iushin.data.clients.GetCurrentUserNameClientImpl
import com.iushin.data.clients.SignOutClientImpl
import org.koin.dsl.module

val dataModule = module {
    single {
        Firebase.auth
    }

    factory<AuthorizationClient> {
        AuthorizationClientImpl(get())
    }

    factory<SignOutClient> {
        SignOutClientImpl(get())
    }

    factory<GetCurrentUserNameClient> {
        GetCurrentUserNameClientImpl(get())
    }
}