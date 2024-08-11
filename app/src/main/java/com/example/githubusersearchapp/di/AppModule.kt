package com.example.mygithubuser.di

import com.example.githubusersearchapp.common.Constants
import com.example.githubusersearchapp.data.remote.GithubRepoApi
import com.example.githubusersearchapp.data.repository.GithubUserRepositoryImpl
import com.example.mygithubuser.domain.repository.GithubUserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGitHubApi(): GithubRepoApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubRepoApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGitHubUserRepository(api: GithubRepoApi): GithubUserRepository {
        return GithubUserRepositoryImpl(api)
    }
}