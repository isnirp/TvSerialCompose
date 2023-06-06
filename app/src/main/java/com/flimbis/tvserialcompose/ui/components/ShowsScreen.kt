package com.flimbis.tvserialcompose.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import com.flimbis.tvserialcompose.model.Shows
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShowsScreen(
    showsLiveData: LiveData<List<Shows>>,
    onDetailsClick: (id:Long) -> Unit
) {
    val shows by showsLiveData.observeAsState()
    shows?.let {
        CardGridView(cardData = shows!!, onDetailsClick)
    }
}

@ExperimentalFoundationApi
@Composable
fun CardGridView(cardData: List<Shows>, onItemClick: (id: Long) -> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(128.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(cardData) { data ->
            CardView(
                title = data.name,
                image = data.image.medium,
                onItemClick = {
                    onItemClick(data.id)
                }
            )
        }
    }
}

// NB
// Use Compose's State and MutableState types to make state observable by Compose
// also; https://developer.android.com/jetpack/compose/libraries#streams