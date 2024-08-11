package com.example.githubusersearchapp.data.remote.dto

import com.example.mygithubuser.data.remote.dto.RepoDto
import com.example.mygithubuser.data.remote.dto.UserDto
import com.example.mygithubuser.data.remote.dto.toRepo
import com.example.mygithubuser.data.remote.dto.toUser
import org.junit.Assert.*

import org.junit.Test

class RepoDtoKtTest {

    @Test
    fun `when dto has empty values`() {
        val repoDto = RepoDto("", "", "", "", true, 1)
        val repo = repoDto.toRepo()
        assertNotNull(repo.name)
        assertNotNull(repo.description)
        assertNotNull(repo.archiveUrl)
        assertNotNull(repo.downloadsUrl)
        assertTrue(repo.allowForking)
        assertEquals(repo.forksCount, 1)
    }

    @Test
    fun `when dto has null values`() {
        val repoDto = RepoDto(null, null, null, null, false, 0)
        val repo = repoDto.toRepo()
        assertNotNull(repo.name)
        assertNotNull(repo.description)
        assertNotNull(repo.archiveUrl)
        assertNotNull(repo.downloadsUrl)
        assertFalse(repo.allowForking)
        assertEquals(repo.forksCount, 0)
    }

    @Test
    fun `when dto has some values`() {
        val repoDto = RepoDto(
            "name_value",
            "description_value",
            "archive_url_value",
            "download_url_value",
            true,
            10)
        val repo = repoDto.toRepo()
        assertNotNull("name_value", repo.name)
        assertNotNull("description_value", repo.description)
        assertNotNull("archive_url_value", repo.archiveUrl)
        assertNotNull("download_url_value", repo.downloadsUrl)
        assertTrue(repo.allowForking)
        assertEquals(10, repo.forksCount)
    }
}