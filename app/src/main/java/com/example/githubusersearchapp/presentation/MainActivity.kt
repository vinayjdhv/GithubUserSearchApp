package com.example.githubusersearchapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.githubusersearchapp.presentation.repo_details.UserRepoDetailScreen
import com.example.githubusersearchapp.presentation.ui.theme.GithubUserSearchAppTheme
import com.example.githubusersearchapp.presentation.user_repo.UserRepoScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GithubUserSearchAppTheme {
                Surface {
                    val navController = rememberNavController()
                    val sharedViewModel = remember {
                        SharedViewModel()
                    }
                    NavHost(
                        navController = navController,
                        startDestination = Screen.UserRepoListScreen.route
                    ) {
                        composable(
                            route = Screen.UserRepoListScreen.route
                        ) {
                            UserRepoScreen(
                                navController = navController,
                                sharedViewModel = sharedViewModel
                            )
                        }
                        composable(
                            route = Screen.RepoDetailScreen.route
                        ) {
                            UserRepoDetailScreen(
                                navController = navController,
                                sharedViewModel = sharedViewModel
                            )
                        }
                    }
                }
            }
        }
    }
}

