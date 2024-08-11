package com.example.githubusersearchapp.presentation

sealed class Screen(val route: String) {
    object UserRepoListScreen: Screen("repo_list_screen")
    object RepoDetailScreen: Screen("repo_detail_screen")
}