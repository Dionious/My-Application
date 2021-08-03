package com.example.myapplication.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.myapplication.domain.models.EmployeeDto

class EmployesDiffUtil(private val oldList:List<EmployeeDto>,private val newList:List<EmployeeDto>):DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean = oldList[oldItemPosition].userNameDto == newList[newItemPosition].userNameDto

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].firtsNameDto != newList[newItemPosition].firtsNameDto -> {
                false
            }
            oldList[oldItemPosition].lastNameDto != newList[newItemPosition].lastNameDto -> {
                false
            }
            oldList[oldItemPosition].userNameDto != newList[newItemPosition].userNameDto -> {
                false
            }
            oldList[oldItemPosition].employeeDateDto != newList[newItemPosition].employeeDateDto -> {
                false
            }
            else -> true
        }
    }
}