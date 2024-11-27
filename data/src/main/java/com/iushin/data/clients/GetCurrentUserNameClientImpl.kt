package com.iushin.data.clients

import com.google.firebase.auth.FirebaseAuth
import com.iushin.data.clientInterfaces.GetCurrentUserNameClient

class GetCurrentUserNameClientImpl(private val authorizer: FirebaseAuth): GetCurrentUserNameClient {
    override suspend fun getName(): String? {
        return authorizer.currentUser?.email
    }
}