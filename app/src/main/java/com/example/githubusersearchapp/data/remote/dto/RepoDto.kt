package com.example.mygithubuser.data.remote.dto


import com.example.mygithubuser.domain.model.Repo
import com.google.gson.annotations.SerializedName

data class RepoDto(
    @SerializedName("name")
    val name: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("archive_url")
    val archiveUrl: String?,
    @SerializedName("downloads_url")
    val downloadsUrl: String?,
    @SerializedName("allow_forking")
    val allowForking: Boolean,
    @SerializedName("forks_count")
    val forksCount: Int,
)

fun RepoDto.toRepo(): Repo {

    return Repo(
        name = name ?: "",
        description = description ?: "",
        archiveUrl = archiveUrl ?: "",
        downloadsUrl = downloadsUrl ?: "",
        allowForking = allowForking,
        forksCount = forksCount
    )
}