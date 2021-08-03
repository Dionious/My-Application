package com.example.myapplication.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.EmployesAdapter
import com.example.myapplication.databinding.FragmentEmployesBinding
import com.example.myapplication.domain.models.EmployeeDto
import com.example.myapplication.domain.models.EmployesModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.threeten.bp.LocalDate

class EmployesFragment : Fragment() {
    private val employesModel: EmployesModel by inject()
    private val employesAdapter:EmployesAdapter by inject()
    private var employesList:List<EmployeeDto>? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentEmployesBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_employes, container, false)
        binding.btnExit.setOnClickListener {
            findNavController().navigate(R.id.navigateToWelcomeFromEmployes)
        }
        binding.recyclerView.adapter = employesAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        CoroutineScope(Dispatchers.Main).launch {
            employesList = getEmployes()
            employesAdapter.setData(employesList!!)
        }
        binding.addData.setOnClickListener {
            val newEmployesList: MutableList<EmployeeDto> = employesList!!.toMutableList()
            newEmployesList.add(EmployeeDto("new_1", "new_1", "new_1", LocalDate.of(2005, 1, 2)))
            employesAdapter.setData(newEmployesList)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            getEmployesInConsole()
        }
    }

    private suspend fun getEmployesInConsole() {
        val list:List<EmployeeDto> = employesModel.getEmployes()
        list.forEach { println(it) }
    }
    private suspend fun getEmployes() = employesModel.getEmployes()
}