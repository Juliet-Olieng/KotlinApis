package com.julietolieng.fetchingapis

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.julietolieng.fetchingapis.databinding.ActivityMainBinding
import com.julietolieng.fetchingapis.databinding.UserListBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel:UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }

    override fun onResume() {
        super.onResume()
        viewModel.fetchUser()
        binding.rvUsers.layoutManager=LinearLayoutManager(this)
        viewModel.errLiveData.observe(this, Observer {
            str ->Toast.makeText(baseContext,str,Toast.LENGTH_LONG).show()
        })
        viewModel.registrationLiveData.observe(this, Observer {
            userList ->
            binding.rvUsers.adapter=UserRVAdapter(userList,this@MainActivity)
            Toast.makeText(baseContext,"users successful",Toast.LENGTH_LONG).show()
        })
    }

}






