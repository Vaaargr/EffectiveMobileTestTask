package com.iushin.domain.entity

sealed class SignInState {
    data object SUCCESSFUL: SignInState()
    data object UNSUCCESSFUL: SignInState()
}