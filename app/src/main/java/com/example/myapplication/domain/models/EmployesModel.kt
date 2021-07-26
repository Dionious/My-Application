package com.example.myapplication.domain.models

import com.example.myapplication.domain.repository.IEmployesRepository

class EmployesModel(private val employes: IEmployesRepository) {
     suspend fun getEmployes(): List<EmployeeDto> {
        return employes.getEmployes()
    }
}