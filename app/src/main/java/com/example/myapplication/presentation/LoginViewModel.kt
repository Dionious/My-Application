package com.example.myapplication.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.models.LoginModel
import kotlinx.coroutines.launch

class LoginViewModel(private val loginModel: LoginModel, val router: Router): ViewModel() {
    private val _btnLoginEnable = MutableLiveData(true)
    private val _etLoginEnable = MutableLiveData(true)
    private val _etPasswordEnable = MutableLiveData(true)
    var btnLoginEnable: LiveData<Boolean> = _btnLoginEnable
    var etLoginEnable: LiveData<Boolean> = _etLoginEnable
    var etPasswordEnable: LiveData<Boolean>  = _etPasswordEnable
    suspend fun signIn(login: String, password: String) {
    viewModelScope.launch {
        _btnLoginEnable.value = false
        _etLoginEnable.value  = false
        _etPasswordEnable.value  = false
        if (loginModel.signIn(login,password).statusResult) {
            router.navigateTo("welcome")
        }
        _btnLoginEnable.value = true
        _etLoginEnable.value  = true
        _etPasswordEnable.value  = true

    }
        }
    }