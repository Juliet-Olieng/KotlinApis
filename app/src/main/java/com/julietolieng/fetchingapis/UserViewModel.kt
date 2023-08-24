package com.julietolieng.fetchingapis

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    var registrationLiveData = MutableLiveData<RegistrationResponse>()
    var regError = MutableLiveData<String>()
    val userRepository = UserRepository()
    fun registerUser(registrationRequest: RegistrationRequest){
        viewModelScope.launch {
            val response = userRepository.registerUser(registrationRequest)
            if (response.isSuccessful){
                registrationLiveData.postValue(response.body())
            }
            else{
                regError.postValue(response.errorBody()?.string())
            }
        }
    }
}







