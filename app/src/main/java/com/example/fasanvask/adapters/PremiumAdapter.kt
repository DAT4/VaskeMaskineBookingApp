package com.example.fasanvask.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fasanvask.databinding.DayCardBinding
import com.example.fasanvask.models.Day
import sh.mama.hangman.adapters.BookingsAdapter

class PremiumAdapter(
    private val days: List<Day>
): RecyclerView.Adapter<PremiumAdapter.BookingViewHolder>(){
    inner class BookingViewHolder(val binding: DayCardBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingViewHolder{
        val binding = DayCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookingViewHolder, position: Int) {
        val day = days[position]
        holder.binding.apply {
            val adapter = BookingsAdapter(day.bookings)
            list.adapter
        }
    }

    override fun getItemCount(): Int {
        return days.size
    }
}

