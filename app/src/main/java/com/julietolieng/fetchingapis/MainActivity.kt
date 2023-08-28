package com.julietolieng.fetchingapis

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.julietolieng.fetchingapis.databinding.ActivityMainBinding
import com.julietolieng.fetchingapis.databinding.UserListBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<UserViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.fetchUser()


    }

    override fun onResume() {
        super.onResume()
        viewModel.errLiveData.observe(this, Observer {
            str ->Toast.makeText(baseContext,str,Toast.LENGTH_LONG).show()
        })
        viewModel.registrationLiveData.observe(this, Observer {
            response ->Toast.makeText(baseContext,"users successful",Toast.LENGTH_LONG).show()
        })
    }

}






