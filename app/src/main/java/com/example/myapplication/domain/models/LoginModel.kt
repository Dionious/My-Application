package com.example.myapplication.domain.models

class LoginModel {
    suspend fun signIn(login:String, password:String):SignInResult {
        return SignInResult(status = false)
    }
}