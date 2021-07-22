package com.example.myapplication.presentation

import android.os.Bundle

class Router {
    private val subscribers = hashSetOf<(screenId: String, args:Bundle) -> Unit>()
    fun navigateTo(screenId: String, args:Bundle=Bundle()){
       subscribers.forEach { it.invoke(screenId, args)}
    }

   fun subscribeToNavigationEvent(onNavigate: (screenId: String, args:Bundle) -> Unit) {
         subscribers.add(onNavigate)
    }
    fun unsubscribe(onNavigate: (screenId: String, args:Bundle) -> Unit){
       subscribers.remove(onNavigate)
    }

}