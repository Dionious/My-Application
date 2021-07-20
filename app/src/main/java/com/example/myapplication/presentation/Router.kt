package com.example.myapplication.presentation

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.example.myapplication.R

class Router {
    private val subscribers = hashSetOf<(screenId: String, args:Bundle) -> Unit>()
    fun navigateTo(screenId: String, args:Bundle=Bundle()){
       subscribers.forEach { it to screenId }
    }
   fun subscribeToNavigationEvent(onNavigate: (screenId: String, args:Bundle) -> Unit) {
         subscribers.add(onNavigate)
    }
    fun unsubscribe(onNavigate: (screenId: String, args:Bundle) -> Unit){
       subscribers.remove(onNavigate)
    }

}