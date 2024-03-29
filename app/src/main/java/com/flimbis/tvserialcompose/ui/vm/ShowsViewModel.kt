package com.flimbis.tvserialcompose.ui.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.flimbis.tvserialcompose.data.repo.ShowsRepository
import com.flimbis.tvserialcompose.model.Shows
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ShowsViewModel @Inject constructor(private val showsRepository: ShowsRepository) :
    ViewModel() {
    private val _showsUiState = MutableLiveData<List<Shows>>()
    val showsUiState: LiveData<List<Shows>> = _showsUiState

    init {
        getShows()
    }

    private fun getShows() {
        viewModelScope.launch {
            _showsUiState.value = showsRepository.getAll(1)
        }
    }
}

/*
* ViewModel
* - persists UI state
* - provides access to business logic
*
* ViewModelStoreOwner(activity, fragment) passed to a VM when instantiating it allows the VM to bind to the lifecyle of the VMSO
* NB Composable is not a VMSO
* */