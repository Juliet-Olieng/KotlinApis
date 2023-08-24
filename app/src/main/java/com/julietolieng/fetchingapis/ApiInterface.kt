package com.julietolieng.fetchingapis

import okhttp3.Call
import okhttp3.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiInterface {
    @GET("user")
    suspend fun getUsers():Response<UserResponse>
    @POST("user")
    suspend fun postUser(@Body user:UserData):Call<UserData>
}





