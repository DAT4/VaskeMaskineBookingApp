package com.example.fasanvask.models

import java.util.*

data class Day(
    val day: Calendar,
    val bookings: List<Booking>
)
data class Booking(
    val id: String,
    val time: Long,
    val user: Resident,
)

data class Resident(
    val id:String,
    val room:String,
    val name:String = "",
)

data class User(
    val username: String,
    val password: String
)

data class Token(
    val token: String
) {
    override fun toString(): String {
        return "Bearer: $token"
    }
}