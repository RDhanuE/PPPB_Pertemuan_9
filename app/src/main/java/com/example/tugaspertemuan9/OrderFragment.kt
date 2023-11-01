package com.example.tugaspertemuan9

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.tugaspertemuan9.databinding.FragmentOrderBinding

class OrderFragment : Fragment() {
    private lateinit var binding : FragmentOrderBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOrderBinding.inflate(inflater, container, false)
        val view = binding.root
        with(binding){
            val orderToTicketAction = OrderFragmentDirections.actionOrderFragmentToTypeFragment()

            orderInputType.setOnClickListener{
                findNavController().navigate(orderToTicketAction)
            }

            orderButton.setOnClickListener{
                if (!orderInputType.text?.isEmpty()!!){
                    Toast.makeText(this@OrderFragment.requireActivity(), "Order Success", Toast.LENGTH_SHORT).show()
                    findNavController().navigateUp()
                }
            }

            findNavController().currentBackStackEntry?.savedStateHandle?.let {
                handle ->
                handle.getLiveData<String>("type").observe(viewLifecycleOwner){
                    res ->
                    orderInputType.setText(res)
                }
            }
        }
        return view
    }

}