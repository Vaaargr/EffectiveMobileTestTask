package com.iushin.domain.impl

import com.iushin.domain.api.interactors.AuthorizationInteractor
import com.iushin.domain.api.repositorys.AuthorizationRepository
import com.iushin.domain.entity.SignInState
import com.iushin.domain.entity.SignUpState

class AuthorizationInteractorImpl(private val authRepository: AuthorizationRepository) :
    AuthorizationInteractor {

    override suspend fun createUser(
        email: String,
        password: String,
        listener: (SignUpState) -> Unit
    ) {
        authRepository.createUser(email = email, password = password, listener = listener)
    }

    override suspend fun logIn(email: String, password: String, listener: (SignInState) -> Unit) {
        authRepository.logIn(email = email, password = password, listener = listener)
    }
}