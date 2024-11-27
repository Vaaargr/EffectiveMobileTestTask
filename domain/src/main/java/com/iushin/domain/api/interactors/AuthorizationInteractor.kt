package com.iushin.domain.api.interactors

import com.iushin.domain.entity.SignInState
import com.iushin.domain.entity.SignUpState

interface AuthorizationInteractor {

    suspend fun createUser(email: String, password: String, listener: (SignUpState) -> Unit)

    suspend fun logIn(email: String, password: String, listener: (SignInState) -> Unit)
}