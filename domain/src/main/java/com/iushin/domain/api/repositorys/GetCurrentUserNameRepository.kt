package com.iushin.domain.api.repositorys

interface GetCurrentUserNameRepository {
    suspend fun execute(): String?
}