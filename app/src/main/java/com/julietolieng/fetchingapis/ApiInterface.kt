package com.julietolieng.fetchingapis

import okhttp3.Call
import okhttp3.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
@POST("/user/")
fun postUser(@Body user:UserData):Call<UserData>
@GET("/users")
suspend fun re():Response<UserResponse>


}
interface ApiInterface {
    @POST("/students/register")
    suspend fun registerStudent(@Body registrationRequest:
                                RegistrationRequest): Response<RegistrationResponse>
}





