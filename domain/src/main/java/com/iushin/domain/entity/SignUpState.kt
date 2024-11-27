package com.iushin.domain.entity

sealed class SignUpState {
    data object SignUpSuccessful : SignUpState()
    data class SignUpUnSuccessful(val message: String?): SignUpState()
}