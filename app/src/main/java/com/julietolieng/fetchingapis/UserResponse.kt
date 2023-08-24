package com.julietolieng.fetchingapis

data class UserResponse(
    var users:List<UserData>,
    var total:Int,
    var skip:Int,
    var limit:Int
)




