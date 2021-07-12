package com.example.myapplication.domain.models

import com.example.myapplication.domain.repository.IAuthRepository

class LoginModel (private val repository: IAuthRepository) {
    suspend fun signIn(login: String, password: String): SignInResult {
        return repository.signIn(login, password)
    }
}