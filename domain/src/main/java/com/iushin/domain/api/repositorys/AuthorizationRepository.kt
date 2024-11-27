package com.iushin.domain.api.repositorys

import com.iushin.domain.entity.SignInState
import com.iushin.domain.entity.SignUpState

interface AuthorizationRepository {

    suspend fun createUser(email: String, password: String, listener: (SignUpState) -> Unit)

    suspend fun logIn(email: String, password: String, listener: (SignInState) -> Unit)
}