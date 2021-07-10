package com.example.myapplication.domain.repository

import com.example.myapplication.domain.models.SignInResult

interface IAuthRepository {
    suspend fun signIn(login:String,password:String):SignInResult
}