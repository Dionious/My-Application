package com.example.myapplication.data.repository

import com.example.myapplication.domain.models.SignInResult
import com.example.myapplication.domain.repository.IAuthRepository

class AuthRepository(private val authService: IAuthService):IAuthRepository {
    override suspend fun signIn(login: String, password: String): SignInResult {
        return SignInResult(status = true)
    }
}