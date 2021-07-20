package com.example.myapplication.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.models.LoginModel
import kotlinx.coroutines.launch

class LoginViewModel(private val loginModel: LoginModel, val router: Router): ViewModel() {
    private val _EnterEnable = MutableLiveData(true)
    private val _LoginEnable = MutableLiveData(true)
    private val _PasswordEnable = MutableLiveData(true)
    val passwordText = MutableLiveData("")
    val loginText = MutableLiveData("")
    val enterEnable: LiveData<Boolean> = _EnterEnable
    var loginEnable: LiveData<Boolean> = _LoginEnable
    var passwordEnable: LiveData<Boolean>  = _PasswordEnable
    private fun signIn() {
    viewModelScope.launch {
        _EnterEnable.value = false
        _LoginEnable.value  = false
        _PasswordEnable.value  = false
        if (loginModel.signIn(passwordText.value.toString(), loginText.value.toString()).statusResult) {
            router.navigateTo("welcome")
        }
        _EnterEnable.value = true
        _LoginEnable.value  = true
        _PasswordEnable.value  = true
    }
        }
    fun onClickPassword() {
        signIn()
    }
    }