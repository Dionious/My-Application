package com.example.myapplication.data.repository

import com.example.myapplication.data.models.SignInResponse
import com.example.myapplication.domain.models.SignInResult
import com.example.myapplication.domain.repository.IAuthRepository

class AuthRepository(private val authService: IAuthService):IAuthRepository {
    override suspend fun signIn(login: String, password: String): SignInResult {
        val response = authService.signIn(login,password)
        val result = response.toSignInResult()
        return result
    }
    private fun SignInResponse.toSignInResult() = SignInResult(
        statusResult = statusResponse
    )
}