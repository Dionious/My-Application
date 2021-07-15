package com.example.myapplication.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.myapplication.R
import com.example.myapplication.modules.myModule
import org.koin.core.context.startKoin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onBackPressed() = AlertDialog.Builder(this).apply {
        setTitle("Подтверждение")
        setMessage("Вы уверены, что хотите выйти из программы?")

        setPositiveButton("Да") { _, _ ->
            super.onBackPressed()
        }

        setNegativeButton("Нет"){_, _ ->
        }
        setCancelable(true)
    }.create().show()
}