package com.example.githubusersearchapp.presentation.user_repo

import com.example.mygithubuser.domain.use_case.get_repos.GetReposUseCase
import com.example.mygithubuser.domain.use_case.get_user.GetUserUseCase
import io.mockk.mockk
import org.junit.Test

class UserRepoListViewModelTest{

    private val userUseCase: GetUserUseCase = mockk()
    private val reposUseCase: GetReposUseCase = mockk()
    private val viewModel = UserRepoListViewModel(userUseCase, reposUseCase)

    @Test
    fun `When fetching user`() {
    }

}