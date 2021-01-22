package com.example.fasanvask.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class BookingViewModelProviderFactory(private val bookingRepository: BookingRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BookingViewModel(bookingRepository) as T
    }
}