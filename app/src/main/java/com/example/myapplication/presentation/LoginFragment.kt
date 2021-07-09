package com.example.myapplication.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.Navigation
import com.example.myapplication.R
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var btnLogin: Button
    private lateinit var etLogin: EditText
    private lateinit var etPassword: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        etLogin = view.findViewById(R.id.etLogin) as EditText
        etPassword = view.findViewById(R.id.etPassword) as EditText
        btnLogin = view.findViewById(R.id.btnLogin) as Button
        btnLogin.setOnClickListener(View.OnClickListener {
            Navigation.findNavController(view).navigate(R.id.navigateToWelcome)

        })
        return view
    }
}