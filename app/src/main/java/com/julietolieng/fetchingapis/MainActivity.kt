package com.julietolieng.fetchingapis

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.julietolieng.fetchingapis.databinding.ActivityMainBinding
import com.julietolieng.fetchingapis.databinding.UserListBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userRVAdapter: UserRVAdapter
    private val viewModel by viewModels<UserViewModel>()
    private var userList:List<UserData> = emptyList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModel.fetchUser()
        initializeList()

    }
    @SuppressLint("NotifyDataSetChanged")
    fun initializeList(){
        viewModel.userList.observe(this){
          users -> users?.let {
              userList=it
            userRVAdapter= UserRVAdapter(userList,this)
            binding.rvUsers.layoutManager=GridLayoutManager(this@MainActivity,2)
            binding.rvUsers.adapter=userRVAdapter
            userRVAdapter.notifyDataSetChanged()
        }
        }
    }
}






