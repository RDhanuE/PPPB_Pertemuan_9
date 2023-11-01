package com.example.tugaspertemuan9

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.tugaspertemuan9.databinding.FragmentTypeBinding

class TypeFragment : Fragment() {
    lateinit var binding: FragmentTypeBinding
    lateinit var selectedType : String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTypeBinding.inflate(inflater, container, false)
        val view = binding.root
        with(binding){
            val typeArrayAdapter = ArrayAdapter(this@TypeFragment.requireActivity(), android.R.layout.simple_spinner_item, resources.getStringArray(R.array.list_ticket_type))
            typeArrayAdapter.setDropDownViewResource(com.google.android.material.R.layout.support_simple_spinner_dropdown_item)
            typeSpinner.adapter = typeArrayAdapter

            typeSpinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener{
                    override fun onItemSelected(p0: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        selectedType = resources.getStringArray(R.array.list_ticket_type)[position]
                    }

                    override fun onNothingSelected(p0: AdapterView<*>?) {
                    }
                }

            typeButton.setOnClickListener{
                findNavController().apply {
                    previousBackStackEntry?.savedStateHandle?.set("type", selectedType)
                }.navigateUp()
            }
        }


        return view
    }
}