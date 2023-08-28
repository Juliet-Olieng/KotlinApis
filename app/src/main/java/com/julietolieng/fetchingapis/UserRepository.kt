package com.julietolieng.fetchingapis

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import retrofit2.http.Body

class UserRepository {
    private val apiInterface = ApiClient.buildClient(ApiInterface::class.java)
    suspend fun registerUser(): Response<List<UserData>> {
       return withContext(Dispatchers.IO){
           apiInterface.registerUser()
       }
    }


}