package com.julietolieng.fetchingapis

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    val apiClient=ApiClient.buildClient(ApiInterface::class.java)
    var _userList:MutableLiveData<List<UserData>> = MutableLiveData()
    val userList:LiveData<List<UserData>> =_userList

    fun fetchUser(){
        viewModelScope.launch {
            val response=apiClient.getUsers()
            if (response.isSuccessful){
                val users = response.body()?.users?: emptyList<>()
                _userList.value=users
            }
        }
    }
}







