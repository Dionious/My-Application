package com.example.myapplication.presentation

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

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