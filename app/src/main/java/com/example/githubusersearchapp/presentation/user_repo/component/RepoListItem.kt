package com.example.githubusersearchapp.presentation.user_repo.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.mygithubuser.domain.model.Repo

@Composable
fun RepoListItem(
    repo: Repo,
    onItemClick: (Repo) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(repo) }
            .padding(2.dp)
            .background(Color.LightGray)
    ) {
        Text(
            modifier = Modifier.padding(2.dp),
            text = repo.name,
            style = MaterialTheme.typography.titleMedium,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            modifier = Modifier.padding(2.dp),
            text = repo.description,
            style = MaterialTheme.typography.bodySmall
        )
    }
}