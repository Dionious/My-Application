package com.example.myapplication.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.myapplication.R


class WelcomeFragment : Fragment() {
    private lateinit var btnExit: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)
        btnExit = view.findViewById(R.id.btnExit) as Button
        btnExit.setOnClickListener(View.OnClickListener {
            Navigation.findNavController(view).navigate(R.id.navigateToLogin)
        })
        return view
    }

}