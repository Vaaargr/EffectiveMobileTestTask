package com.iushin.data.clientInterfaces

interface GetCurrentUserNameClient {
    suspend fun getName(): String?
}