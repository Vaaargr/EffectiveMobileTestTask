package com.iushin.domain.impl

import com.iushin.domain.api.repositorys.GetCurrentUserNameRepository

class GetCurrentUserNameUseCase(private val repository: GetCurrentUserNameRepository) {
    suspend fun execute(): String?{
        return repository.execute()
    }
}