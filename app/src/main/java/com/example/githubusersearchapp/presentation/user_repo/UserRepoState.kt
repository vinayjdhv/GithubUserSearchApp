package com.example.githubusersearchapp.presentation.user_repo

import com.example.mygithubuser.domain.model.Repo

data class UserRepoState(
    val isLoading: Boolean = false,
    val repos: List<Repo> = ArrayList(),
    val error: String = ""
)
