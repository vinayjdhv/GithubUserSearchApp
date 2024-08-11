package com.example.githubusersearchapp.presentation.user_repo

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.githubusersearchapp.presentation.Screen
import com.example.githubusersearchapp.presentation.SharedViewModel
import com.example.githubusersearchapp.presentation.user_repo.component.RepoListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserRepoScreen(
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
                    text = "Take Home",
                    color = Color.White,
                )
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Color.Blue
        )
        )
        Spacer(modifier = Modifier.height(10.dp))
        SearchBar(viewModel)
        Spacer(modifier = Modifier.height(10.dp))
        ShowAvatar(
            viewModel.userState.value.user?.name,
            viewModel.userState.value.user?.avatarUrl
        )
        Spacer(modifier = Modifier.height(10.dp))
        RepoList(viewModel, sharedViewModel, navController)
    }

}

@Composable
fun SearchBar(viewModel: UserRepoListViewModel) {

    var userName by remember { mutableStateOf(TextFieldValue("")) }

    Row {
        OutlinedTextField(
            value = userName,
            onValueChange = {
                userName = it
            },
            label = @Composable { if (userName.text.isNotBlank()) Text(text = "Enter a github user id") },
            readOnly = false,
            placeholder = {
                Text(text = "Enter a github user id")
            },
            singleLine = true
        )

        Button(
            modifier = Modifier.padding(5.dp)
                .align(Alignment.CenterVertically),
            onClick = {
                viewModel.userName = userName.text
                viewModel.getUser()
                viewModel.getUserRepos()

            }) {
            Text(text = "Search")
        }
    }
}

@Composable
fun ShowAvatar(name: String?, imageUrl: String?){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        imageUrl?.let {
            Image(
                painter = rememberAsyncImagePainter(it),
                contentDescription = null,
                modifier = Modifier
                    .size(128.dp)
            )
        }
        name?.let {
            Text(text = name)
        }
    }

}

@Composable
fun RepoList(
    viewModel: UserRepoListViewModel,
    sharedViewModel: SharedViewModel,
    navController: NavController
) {
    val userRepoState = viewModel.userRepoState.value


    Box (
        modifier = Modifier.fillMaxSize()
    ){
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(userRepoState.repos) { repo ->
                RepoListItem(
                    repo = repo,
                    onItemClick = {
                        sharedViewModel.repo.value = repo
                        navController.navigate(Screen.RepoDetailScreen.route)
                    },
                )
            }
        }

        if (userRepoState.error.isNotBlank()) {
            Text(
                text = userRepoState.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .align(Alignment.Center)
            )
        }

        if (userRepoState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

    }
}