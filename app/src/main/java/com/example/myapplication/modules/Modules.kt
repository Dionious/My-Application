package com.example.myapplication.modules

import com.example.myapplication.data.repository.AuthRepository
import com.example.myapplication.data.repository.IAuthService
import com.example.myapplication.data.repository.StubAuthService
import com.example.myapplication.domain.models.LoginModel
import com.example.myapplication.domain.repository.IAuthRepository
import com.example.myapplication.presentation.LoginViewModel
import com.example.myapplication.presentation.Router
import org.koin.dsl.module

val myModule = module {
    single { LoginModel(get())}
    single { AuthRepository(get()) as IAuthRepository}
    single {LoginViewModel(get(),get())}
    single { Router() }
    single { StubAuthService() as IAuthService }
}