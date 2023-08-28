package com.julietolieng.fetchingapis

import okhttp3.Call
import retrofit2.Response

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiInterface {
    @GET("user")
    suspend fun registerUser(): Response<List<UserData>>
    companion object{
        var apiInterface:ApiInterface?=null
    }

}





