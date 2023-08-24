package com.julietolieng.fetchingapis

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.julietolieng.fetchingapis.databinding.ActivityMainBinding
import com.julietolieng.fetchingapis.databinding.UserListBinding

class UserRVAdapter(private var userList: List<UserData>, private val context: Context):RecyclerView.Adapter<UserViewHolder>() {
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
        binding.tvTitle.text=currentUser.title.toString()
    }

}
class UserViewHolder(var binding:UserListBinding ):RecyclerView.ViewHolder(binding.root){}



//class ProductRVAdapter(private var productList: List<Product>, private val context: Context) : RecyclerView.Adapter<ProductViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
//        val binding = ProducListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return ProductViewHolder(binding)
//    }
//
//    override fun getItemCount(): Int {
//        return productList.size
//    }
//
//    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
//        val currentProduct = productList[position]
//        val binding = holder.binding
//
//        binding.tvName.text = currentProduct.title
//        binding.tvPrice.text = currentProduct.price.toString()
//        binding.tvRatings.text = currentProduct.rating.toString()
//        binding.tvDescription.text = currentProduct.desc
//
//        Picasso
//            .get()
//            .load(currentProduct.thumbnail)
//            .resize(80, 80)
//            .centerCrop()
//            .transform(CropCircleTransformation())
//            .into(binding.ivContact)
//
//        binding.ivContact.setOnClickListener {
//            val intent = Intent(context, ProductDescription::class.java)
//            intent.putExtra("PRODUCT_ID", currentProduct.id)
//            intent.putExtra("PRODUCT_TITLE", currentProduct.title)
//            context.startActivity(intent)
//
//        }
//    }
//}
//
//class ProductViewHolder(var binding: ProducListBinding) : RecyclerView.ViewHolder(binding.root) {}
