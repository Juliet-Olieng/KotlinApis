package com.julietolieng.fetchingapis

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.julietolieng.fetchingapis.databinding.ActivityMainBinding
import com.julietolieng.fetchingapis.databinding.UserListBinding

class UserRVAdapter(private var userList: List<UserData>, var context: Context):RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding=UserListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int {
       return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
      val currentUser=userList[position]
        val binding=holder.binding
        binding.tvBody.text=currentUser.body.toString()
        binding.tvId.text=currentUser.id.toString()
        binding.tvUserId.text=currentUser.userId.toString()
        binding.tvTitle.text=currentUser.title.toString()

    }

}
class UserViewHolder(var binding:UserListBinding ):RecyclerView.ViewHolder(binding.root){}


