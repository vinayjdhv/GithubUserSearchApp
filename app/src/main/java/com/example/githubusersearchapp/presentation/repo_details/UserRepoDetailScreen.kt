package com.example.githubusersearchapp.presentation.repo_details

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.githubusersearchapp.presentation.SharedViewModel
import com.example.githubusersearchapp.presentation.user_repo.UserRepoListViewModel
import com.example.mygithubuser.domain.model.Repo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserRepoDetailScreen(
    navController: NavController,
    sharedViewModel: SharedViewModel,
    viewModel: UserRepoListViewModel = hiltViewModel()
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ){
        TopAppBar(
            title = {
                Text(
                    style = MaterialTheme.typography.titleLarge,
                    text = "Repo details",
                    color = Color.White,
                )
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Color.Blue
            ),
            navigationIcon = {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(Icons.Filled.ArrowBack, null)
                }
            })
        Spacer(modifier = Modifier.height(15.dp))
        sharedViewModel.repo.value?.let { ShowRepoDetails(it) }
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
               navController.popBackStack()
            }) {
            Text(text = "Back")
        }
    }

}

@Composable
fun ShowRepoDetails(repo: Repo){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "Repo Name : ${repo.name}",
            modifier = Modifier.padding(10.dp))
        Text(text = "Description : ${repo.description}",
            modifier = Modifier.padding(10.dp))
        Text(text = "ArchiveUrl : ${repo.archiveUrl}",
            modifier = Modifier.padding(10.dp))
        Text(text = "Download Url : ${repo.downloadsUrl}",
            modifier = Modifier.padding(10.dp))
        Text(text = "Fork count : ${repo.forksCount}",
            modifier = Modifier.padding(10.dp))
        if (repo.forksCount > 5000){
            Text(
                text = "You got more than 5000 forks",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Red
            )
        }
    }
}