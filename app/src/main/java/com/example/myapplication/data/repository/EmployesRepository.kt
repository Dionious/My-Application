package com.example.myapplication.data.repository

import com.example.myapplication.data.models.Employee
import com.example.myapplication.domain.models.EmployeeDto
import com.example.myapplication.domain.repository.IEmployesRepository

class EmployesRepository(private val employesService: IEmployesService): IEmployesRepository {
    override suspend fun getEmployes(): List<EmployeeDto> {
        val list = employesService.getEmployes()
        val resultList:List<EmployeeDto> = list.toEmployeeDto()
        return resultList
    }
    private fun List<Employee>.toEmployeeDto() = map {EmployeeDto(it.firtsName,it.lastName,it.userName,it.employeeDate)}

}