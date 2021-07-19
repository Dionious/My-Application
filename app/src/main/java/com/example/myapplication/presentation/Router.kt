package com.example.myapplication.presentation

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.example.myapplication.R

class Router {
    lateinit var navController: NavController
    fun navigateTo(screenId: String, args:Bundle=Bundle()){
        when (screenId) {
          "welcome" -> navController.navigate(R.id.navigateToWelcome)
        }
    }
     fun subscribeToNavigationEvent(onNavigate: (screenId: String, args:Bundle) -> NavController) {
         navController = onNavigate("welcome", bundleOf(Pair("welcome",R.id.navigateToWelcome)))
    }

}