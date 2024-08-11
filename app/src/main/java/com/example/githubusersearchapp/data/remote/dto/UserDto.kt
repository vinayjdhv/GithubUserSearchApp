package com.example.mygithubuser.data.remote.dto


import com.example.mygithubuser.domain.model.User
import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("avatar_url")
    val avatarUrl: String?,
    @SerializedName("login")
    val login: String?,
    @SerializedName("name")
    val name: String?,
)

fun UserDto.toUser(): User {
    return User(
        login = login ?: "",
        name = name ?: "",
        avatarUrl = avatarUrl?: ""
    )
}