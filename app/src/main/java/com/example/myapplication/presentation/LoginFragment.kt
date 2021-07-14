package com.example.myapplication.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.myapplication.R
import com.example.myapplication.domain.models.LoginModel
import com.example.myapplication.domain.models.SignInResult
import com.example.myapplication.modules.myModule
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.core.context.startKoin

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
        CoroutineScope(Dispatchers.Main).launch {
            btnLogin.isEnabled = false
           if (checkSignIn(etLogin.text.toString(), etPassword.text.toString())) {
               Navigation.findNavController(view).navigate(R.id.navigateToWelcome)
           }
            else {
                Toast.makeText(context,"Ошибка входа", Toast.LENGTH_SHORT).show()
           }
            btnLogin.isEnabled = true
        }

        })
        return view
    }
    private suspend fun checkSignIn(etLogin:String,etPassword:String):Boolean {
        val login:LoginModel by inject()
        var result:SignInResult
        coroutineScope {
            result = login.signIn(etLogin, etPassword)
        }
        return result.statusResult
    }
}