package com.julietolieng.fetchingapis

import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("id")var id:Int?,
    @SerializedName("title")var title:String?,
    @SerializedName("body")var body:String?

)
