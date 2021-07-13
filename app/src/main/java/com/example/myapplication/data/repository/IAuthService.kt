package com.example.myapplication.data.repository

import com.example.myapplication.data.models.SignInResponse

interface IAuthService {
    suspend fun signIn(login:String,password:String):SignInResponse
}