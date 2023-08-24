package com.julietolieng.fetchingapis

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiInterface = ApiClient.buildClient(ApiInterface::class.java)
    suspend fun registerUser(registrationRequest: RegisterRequest):
            Response<RegisterResponse> =
        withContext(Dispatchers.IO) {
            var resp = apiInterface.registerStudent(registrationRequest)
            return@withContext resp
        }
}