package com.example.githubusersearchapp.presentation.user_repo

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubusersearchapp.common.Resource
import com.example.mygithubuser.domain.use_case.get_repos.GetReposUseCase
import com.example.mygithubuser.domain.use_case.get_user.GetUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UserRepoListViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val getReposUseCase: GetReposUseCase
): ViewModel(){

    private val _userState = mutableStateOf(UserState())
    val userState: State<UserState> = _userState

    private val _userRepoState = mutableStateOf(UserRepoState())
    val userRepoState: State<UserRepoState> = _userRepoState

    var userName = ""

    fun getUser() {
        getUserUseCase(userName).onEach { result->
            when (result) {
                is Resource.Success -> {
                    _userState.value = UserState(user = result.data)
                    userName = userState.value.user?.name.toString()
                }
                is Resource.Error -> {
                    _userState.value = UserState(error = result.message?: "an unexpected error occured")
                }
                is Resource.Loading -> {
                    _userState.value = UserState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun getUserRepos() {
        getReposUseCase(userName).onEach { result->
            when (result){
                is Resource.Success -> {
                    _userRepoState.value = UserRepoState(repos = result.data?: emptyList())
                }
                is Resource.Error -> {
                    _userRepoState.value = UserRepoState(error = result.message?: "an unexpected error occured")
                }
                is Resource.Loading -> {
                    _userRepoState.value = UserRepoState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}