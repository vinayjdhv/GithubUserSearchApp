package com.example.mygithubuser.domain.repository

import com.example.mygithubuser.data.remote.dto.RepoDto
import com.example.mygithubuser.data.remote.dto.UserDto

interface GithubUserRepository {

    suspend fun getUser(userId: String):UserDto

    suspend fun getUserRepos(userId: String): List<RepoDto>

}