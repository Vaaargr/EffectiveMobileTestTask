package com.iushin.domain.impl

import com.iushin.domain.api.repositorys.SignOutRepository

class SignOutUseCase(private val repository: SignOutRepository) {
    suspend fun execute() {
        repository.execute()
    }
}