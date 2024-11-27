package com.iushin.data.repositorys

import com.iushin.data.clientInterfaces.GetCurrentUserNameClient
import com.iushin.domain.api.repositorys.GetCurrentUserNameRepository

class GetCurrentUserRepositoryImpl(private val client: GetCurrentUserNameClient) :
    GetCurrentUserNameRepository {
    override suspend fun execute(): String? {
        return client.getName()
    }
}