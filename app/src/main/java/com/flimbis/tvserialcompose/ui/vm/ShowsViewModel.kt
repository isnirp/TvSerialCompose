package com.flimbis.tvserialcompose.ui.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flimbis.tvserialcompose.data.repo.ShowsRepository
import kotlinx.coroutines.launch

class ShowsViewModel(private val showsRepository: ShowsRepository): ViewModel() {
    fun getShows() {
        viewModelScope.launch {
            showsRepository.getAll(1)
        }
    }
}