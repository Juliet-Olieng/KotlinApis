package com.julietolieng.fetchingapis

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    var registrationLiveData = MutableLiveData<List<UserData>>()
    val errLiveData=MutableLiveData<String>()
    private val userRepository=UserRepository()

    fun fetchUser(){
        viewModelScope.launch {
            val response=userRepository.registerUser()
            if (response.isSuccessful) {
                registrationLiveData.postValue(response.body()?: emptyList())
            }
            else{
                errLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}







