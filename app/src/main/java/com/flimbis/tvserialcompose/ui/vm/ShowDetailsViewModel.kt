package com.flimbis.tvserialcompose.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flimbis.tvserialcompose.data.repo.ShowsRepository
import com.flimbis.tvserialcompose.model.Shows
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val showsRepository: ShowsRepository
) : ViewModel() {

    private val showId: Long = checkNotNull(savedStateHandle["id"])

    private val _show = MutableLiveData<Shows>()
    val show: LiveData<Shows> = _show

    init {
        getShow(showId)
    }

    fun getShow(id: Long) {
        viewModelScope.launch {
            _show.value = showsRepository.get(id)
        }
    }
}