package com.iushin.data.repositorys

import com.iushin.data.clientInterfaces.SignOutClient
import com.iushin.domain.api.repositorys.SignOutRepository

class SignOutRepositoryImpl(private val client: SignOutClient): SignOutRepository {
    override suspend fun execute() {
        client.execute()
    }
}