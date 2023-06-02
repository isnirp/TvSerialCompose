package com.flimbis.tvserialcompose.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
//import androidx.compose.foundation.lazy.GridCells
//import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import com.flimbis.tvserialcompose.model.Shows
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShowsScreen(showsLiveData: LiveData<List<Shows>>) {
    val shows by showsLiveData.observeAsState()
    shows?.let {
        CardGridView(cardData = shows!!)
    }
}

@ExperimentalFoundationApi
@Composable
fun CardGridView(cardData: List<Shows>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(cardData) { data ->
            CardView(
                title = data.name,
                image = data.image.medium
            )
        }
    }
}

// NB
// Use Compose's State and MutableState types to make state observable by Compose
// also; https://developer.android.com/jetpack/compose/libraries#streams