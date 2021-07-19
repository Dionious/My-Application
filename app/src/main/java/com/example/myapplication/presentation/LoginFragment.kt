package com.example.myapplication.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLoginBinding
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class LoginFragment : Fragment() {
    private val viewModel : LoginViewModel by inject()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentLoginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        viewModel.router.subscribeToNavigationEvent(onNavigate = { _, _ -> findNavController() })
        binding.btnLogin.setOnClickListener(View.OnClickListener {
        viewModel.viewModelScope.launch {
           viewModel.signIn(binding.etLogin.text.toString(), binding.etPassword.text.toString())
        }
        })
        return binding.root
    }
}