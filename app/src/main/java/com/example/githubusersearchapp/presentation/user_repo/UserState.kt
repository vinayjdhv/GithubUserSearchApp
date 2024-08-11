package com.example.githubusersearchapp.presentation.user_repo

import com.example.mygithubuser.domain.model.User

data class UserState(
    val isLoading: Boolean = false,
    val user: User? = null,
    val error: String = ""
)
