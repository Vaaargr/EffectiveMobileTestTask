package com.iushin.effectivemobiletesttask.presentation.state

sealed class AuthorizationUIState (val state: Boolean){
    data object ENTRANCE: AuthorizationUIState(true)
    data object REGISTRATION: AuthorizationUIState(false)
}