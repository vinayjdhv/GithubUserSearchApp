package com.example.githubusersearchapp.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mygithubuser.domain.model.Repo


class SharedViewModel: ViewModel() {
    var repo = MutableLiveData<Repo>()
}