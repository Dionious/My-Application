package com.example.myapplication.domain.repository

import com.example.myapplication.domain.models.EmployeeDto

interface IEmployesRepository {
    suspend fun getEmployes():List<EmployeeDto>
}