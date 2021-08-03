package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.domain.models.EmployeeDto
import kotlinx.android.synthetic.main.card_employes.view.*


class EmployesAdapter: RecyclerView.Adapter<EmployesAdapter.MyViewHolder>() {
    private var employesList = emptyList<EmployeeDto>()
    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_employes,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.firstName.text = employesList[position].firtsNameDto
        holder.itemView.lastName.text = employesList[position].lastNameDto
        holder.itemView.userName.text = employesList[position].userNameDto
        holder.itemView.employeeDate.text = employesList[position].employeeDateDto.toString()
    }

    override fun getItemCount(): Int = employesList.size

    fun setData(newEmployesList: List<EmployeeDto>) {
        val diffUtil = EmployesDiffUtil(employesList,newEmployesList)
        val diffResults = DiffUtil.calculateDiff(diffUtil)
        employesList = newEmployesList
        diffResults.dispatchUpdatesTo(this)
    }
}