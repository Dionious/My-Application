package com.example.myapplication.data.repository

import com.example.myapplication.data.models.SignInResponse
import kotlinx.coroutines.delay

class StubAuthService:IAuthService {
    override suspend fun signIn(login: String, password: String): SignInResponse {
        delay(2000)
        return if ((login == password) && (login.isNotEmpty()) && (password.isNotEmpty())){
            SignInResponse(statusResponse = true)
        } else {
            SignInResponse(statusResponse = false)
        }
    }
}