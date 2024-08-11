package com.example.githubusersearchapp.domain.use_case.get_user

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.mygithubuser.domain.repository.GithubUserRepository
import com.example.mygithubuser.domain.use_case.get_user.GetUserUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class GetUserUseCaseTest{

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    private val repository: GithubUserRepository = mockk{
        coEvery { getUser(any()) } returns mockk()
    }
    private val reposUseCase = GetUserUseCase(repository)

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
    }

    @Test
    fun `GetUserUseCase invoke`(){
        val firstItem = reposUseCase.invoke("")
        dispatcher.scheduler.advanceUntilIdle()
    }

}