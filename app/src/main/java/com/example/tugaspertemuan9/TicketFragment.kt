package com.example.tugaspertemuan9

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.tugaspertemuan9.databinding.FragmentTicketBinding

class TicketFragment : Fragment() {
    lateinit var binding: FragmentTicketBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTicketBinding.inflate(inflater, container, false)
        val view = binding.root
        with(binding){
            val ticketToOrderAction = TicketFragmentDirections.actionTicketFragmentToOrderFragment()

            ticketButton.setOnClickListener{
                findNavController().navigate(ticketToOrderAction)
            }
        }
        return view
    }


}