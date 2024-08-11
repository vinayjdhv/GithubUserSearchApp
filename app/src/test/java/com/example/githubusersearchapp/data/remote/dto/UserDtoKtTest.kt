package com.example.githubusersearchapp.data.remote.dto

import com.example.mygithubuser.data.remote.dto.UserDto
import com.example.mygithubuser.data.remote.dto.toUser
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue

import org.junit.Test

class UserDtoKtTest {

    @Test
    fun `when dto has empty values`() {
        val userDto = UserDto(login = "", name = "", avatarUrl = "")
        val user = userDto.toUser()
        assertNotNull(user.login)
        assertNotNull(user.name)
        assertNotNull(user.avatarUrl)
    }

    @Test
    fun `when dto has null values`() {
        val userDto = UserDto(null, null, null)
        val user = userDto.toUser()
        assertNotNull(user.login)
        assertNotNull(user.name)
        assertNotNull(user.avatarUrl)
    }

    @Test
    fun `when dto has some values`() {
        val userDto = UserDto(login = "login_value", name = "name_value", avatarUrl = "url_value")
        val user = userDto.toUser()
        assertEquals("login_value", user.login)
        assertNotNull("name_value", user.name)
        assertNotNull("url_value", user.avatarUrl)
    }

}