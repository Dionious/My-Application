package com.example.myapplication.modules

import com.example.myapplication.data.repository.*
import com.example.myapplication.domain.models.EmployesModel
import com.example.myapplication.domain.models.LoginModel
import com.example.myapplication.domain.repository.IAuthRepository
import com.example.myapplication.domain.repository.IEmployesRepository
import com.example.myapplication.presentation.LoginViewModel
import com.example.myapplication.presentation.Router
import org.koin.dsl.module

val myModule = module {
    single { LoginModel(get()) }
    single { AuthRepository(get()) as IAuthRepository }
    single { LoginViewModel(get(),get()) }
    single { Router() }
    single { StubAuthService() as IAuthService }
    single { EmployesModel(get()) }
    single { EmployesRepository(get()) as IEmployesRepository }
    single { StubEmployesService() as IEmployesService }
}