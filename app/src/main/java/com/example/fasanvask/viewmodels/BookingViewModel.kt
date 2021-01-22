package com.example.fasanvask.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fasanvask.models.Booking
import com.example.fasanvask.api.Resource
import com.example.fasanvask.models.Token
import com.example.fasanvask.models.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BookingViewModel(val bookingRepository: BookingRepository): ViewModel() {

    private val _bookings = MutableStateFlow<Resource<List<Booking>>>(Resource.Nil())
    val bookings: StateFlow<Resource<List<Booking>>> = _bookings

    private val _token = MutableStateFlow<Resource<Token>>(Resource.Nil())
    val token: StateFlow<Resource<Token>> = _token

    fun login(user: User){
        viewModelScope.launch {
            _token.value = bookingRepository.login(user)
        }
    }

    fun loadBookings(){
        viewModelScope.launch {
            if (token.value is Resource.Success) {
                _bookings.value = bookingRepository.getBookings(token.value.data!!)
            }
        }
    }


}