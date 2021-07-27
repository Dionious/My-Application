package com.example.myapplication.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLoginBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class LoginFragment : Fragment() {
    private val viewModel by viewModel<LoginViewModel>()
    private val router : Router by inject()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val navHostFragment = activity?.supportFragmentManager?.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        val binding:FragmentLoginBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel
        router.subscribeToNavigationEvent(onNavigate = { dest, bundle -> navController.navigate(R.id.navigateToWelcomeFromLogin, bundleOf(Pair("welcome",R.id.navigateToWelcomeFromLogin))) })
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        router.unsubscribe(onNavigate = { dest, bundle -> findNavController().navigate(R.id.navigateToWelcomeFromLogin, bundleOf(Pair("welcome",R.id.navigateToWelcomeFromLogin))) })
    }
}