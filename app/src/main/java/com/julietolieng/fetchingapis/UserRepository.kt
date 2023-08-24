package com.julietolieng.fetchingapis

import retrofit2.Response

class UserRepository {
    val apiInterface = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun registerUser(registrationRequest: RegisterRequest):
            Response<RegistrationResponse> =
        withContext(Dispatchers.IO) {
            var resp = apiInterface.registerStudent(registrationRequest)
            return@withContext resp
        }
}