package com.example.mygithubuser.domain.use_case.get_user


import com.example.githubusersearchapp.common.Resource
import com.example.mygithubuser.data.remote.dto.toUser
import com.example.mygithubuser.domain.model.User
import com.example.mygithubuser.domain.repository.GithubUserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val repository: GithubUserRepository
){
    operator fun invoke(userId: String): Flow<Resource<User>> = flow {
        try {
            emit(Resource.Loading())
            val user = repository.getUser(userId).toUser()
            emit(Resource.Success(user))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach to server. Check your internet connection"))
        }
    }
}