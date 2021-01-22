package com.example.fasanvask.viewmodels

import com.example.fasanvask.models.Booking
import com.example.fasanvask.api.Resource
import com.example.fasanvask.models.Token
import com.example.fasanvask.models.User
import dtu.android.moroapp.api.RetrofitInstance
import retrofit2.Response

class BookingRepository {
    suspend fun getBookings(token: Token): Resource<List<Booking>> {
        return if (BookingCache.cacheList.isEmpty()) {
            handleGetEvents(RetrofitInstance.api.get(token.token))
        } else {
            Resource.Success(BookingCache.cacheList)
        }
    }

    suspend fun login(user: User) : Resource<Token> {
        val response = RetrofitInstance.api.getToken(user)
        return if (response.isSuccessful) {
            Resource.Success(response.body()!!)
        } else {
            Resource.Error(response.message())
        }
    }

    private fun handleGetEvents(response: Response<List<Booking>>): Resource<List<Booking>> {
        return if (response.isSuccessful) {
            Resource.Success(response.body()!!)
                .also {
                    BookingCache.cacheList = it.data ?: emptyList()
                }
        } else {
            Resource.Error(response.message())
        }
    }
}

