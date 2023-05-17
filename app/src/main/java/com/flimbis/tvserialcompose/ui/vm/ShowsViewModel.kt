package com.flimbis.tvserialcompose.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flimbis.tvserialcompose.data.repo.ShowsRepository
import com.flimbis.tvserialcompose.model.Shows
import kotlinx.coroutines.launch

class ShowsViewModel(private val showsRepository: ShowsRepository): ViewModel() {
    private val _shows = MutableLiveData<List<Shows>>()
    val shows: LiveData<List<Shows>> = _shows

    fun getShows() {
        viewModelScope.launch {
            _shows.value = showsRepository.getAll(1)
        }
    }
}

/*
* ViewModel
* - persists UI state
* - provides access to business logic
*
* ViewModelStoreOwner passed to a VM when instantiating it allows the VM to bind to the lifecyle of the VMSO
* NB Composable is not a VMSO
* */