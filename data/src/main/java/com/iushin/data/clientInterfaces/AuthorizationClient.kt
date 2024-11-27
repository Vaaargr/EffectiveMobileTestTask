package com.iushin.data.clientInterfaces

import com.iushin.domain.entity.SignInState
import com.iushin.domain.entity.SignUpState

interface AuthorizationClient {
    suspend fun createUser(email: String, password: String, listener: (SignUpState) -> Unit)

    suspend fun logIn(email: String, password: String, listener: (SignInState) -> Unit)
}