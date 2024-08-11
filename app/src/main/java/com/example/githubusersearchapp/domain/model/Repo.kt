package com.example.mygithubuser.domain.model

data class Repo(
    val name: String,
    val description: String,
    val archiveUrl: String,
    val downloadsUrl: String,
    val allowForking: Boolean,
    val forksCount: Int
)