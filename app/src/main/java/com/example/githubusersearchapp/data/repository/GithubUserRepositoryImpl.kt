package com.example.githubusersearchapp.data.repository

import com.example.githubusersearchapp.data.remote.GithubRepoApi
import com.example.mygithubuser.data.remote.dto.RepoDto
import com.example.mygithubuser.data.remote.dto.UserDto
import com.example.mygithubuser.domain.repository.GithubUserRepository
import javax.inject.Inject

class GithubUserRepositoryImpl @Inject constructor(
    private val api: GithubRepoApi
) : GithubUserRepository{

    override suspend fun getUser(userId: String): UserDto {
        return api.getUser(userId)
    }

    override suspend fun getUserRepos(userId: String): List<RepoDto> {
        return api.getUserRepos(userId)
    }
}