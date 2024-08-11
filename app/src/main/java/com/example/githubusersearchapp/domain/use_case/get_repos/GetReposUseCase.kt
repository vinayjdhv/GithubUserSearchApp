package com.example.mygithubuser.domain.use_case.get_repos

import com.example.githubusersearchapp.common.Resource
import com.example.mygithubuser.data.remote.dto.toRepo
import com.example.mygithubuser.domain.model.Repo
import com.example.mygithubuser.domain.repository.GithubUserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetReposUseCase @Inject constructor(
    private val repository: GithubUserRepository
){
    operator fun invoke(userId: String): Flow<Resource<List<Repo>>> = flow {

        try {
            emit(Resource.Loading())
            val repos = repository.getUserRepos(userId).map { it.toRepo() }
            emit(Resource.Success(repos))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach to server. Check your internet connection"))
        }
    }
}