package com.example.myapplication.data.repository

import com.example.myapplication.data.models.Employee

interface IEmployesService {
    suspend fun getEmployes():List<Employee>
}