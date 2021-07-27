package com.example.myapplication.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentEmployesBinding
import com.example.myapplication.databinding.FragmentWelcomeBinding
import com.example.myapplication.domain.models.EmployeeDto
import com.example.myapplication.domain.models.EmployesModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class EmployesFragment : Fragment() {
    private val employesModel: EmployesModel by inject()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentEmployesBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_employes, container, false)
        binding.btnExit.setOnClickListener {
            findNavController().navigate(R.id.navigateToWelcomeFromEmployes)
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
}