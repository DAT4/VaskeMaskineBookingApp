package com.example.fasanvask

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fasanvask.adapters.PremiumAdapter
import com.example.fasanvask.databinding.FragmentInsideBinding
import com.example.fasanvask.models.Day

class InsideFragment : Fragment() {
    private lateinit var _binding: FragmentInsideBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentInsideBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        printBookings()
    }

    private fun printBookings(){
        val days = emptyList<Day>()
        try {
            val adapter = PremiumAdapter(days)
            binding.viewpager.adapter = adapter
        } catch (e: java.lang.Exception) {
            println(e)
        }
    }
}