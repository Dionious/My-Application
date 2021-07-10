package com.example.myapplication.data.repository

import com.example.myapplication.data.models.SignInResponse

class StubAuthService:IAuthService {
    override suspend fun signIn(login: String, password: String): SignInResponse {
        return SignInResponse(status = true)
    }
}