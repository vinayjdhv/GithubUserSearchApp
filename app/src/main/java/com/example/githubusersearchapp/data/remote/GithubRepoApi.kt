package com.example.githubusersearchapp.data.remote

import com.example.mygithubuser.data.remote.dto.RepoDto
import com.example.mygithubuser.data.remote.dto.UserDto
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubRepoApi {

    @GET("/users/{userId}")
    suspend fun getUser(@Path("userId") userId: String): UserDto

    @GET("/users/{userId}/repos")
    suspend fun getUserRepos(@Path("userId") userId: String): List<RepoDto>
}