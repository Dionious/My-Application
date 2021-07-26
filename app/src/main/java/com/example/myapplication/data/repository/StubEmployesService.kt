package com.example.myapplication.data.repository

import com.example.myapplication.data.models.Employee
import kotlinx.coroutines.delay
import org.threeten.bp.LocalDate

class StubEmployesService:IEmployesService {
    override suspend fun getEmployes(): List<Employee> {
        delay(2000)
        return listOf(
            Employee("test1_fn", "test1_ln", "test1_un", LocalDate.of(2001, 5, 1)),
            Employee("test2_fn", "test2_ln", "test2_un", LocalDate.of(2002, 10, 2)),
            Employee("test3_fn", "test3_ln", "test3_un", LocalDate.of(2003, 9, 6)),
            Employee("test4_fn", "test4_ln", "test4_un", LocalDate.of(2004, 8, 3)),
            Employee("test5_fn", "test5_ln", "test5_un", LocalDate.of(2005, 7, 4))
        )
    }
}