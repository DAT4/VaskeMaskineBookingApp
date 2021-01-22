package com.example.fasanvask.api

import com.example.fasanvask.models.Booking
import com.example.fasanvask.models.Token
import com.example.fasanvask.models.User
import retrofit2.Response
import retrofit2.http.*

interface API {
    @GET("/proxy/get")
    suspend fun get(@Header("Authorization") token: String): Response<List<Booking>>
    @POST("/proxy/book")
    suspend fun create (@Header("Authorization") token: String, @Body user: User): Response<List<Booking>>
    @POST("/proxy/delete")
    suspend fun delete(@Header("Authorization") token: String, @Body user: User): Response<List<Booking>>
    @POST("/proxy/token")
    suspend fun getToken(@Body user: User): Response<Token>
}