package com.flimbis.tvserialcompose.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import com.flimbis.tvserialcompose.model.Shows
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    showsLiveData: LiveData<List<Shows>>,
    onNavToShow: (id: Long) -> Unit,
    paddingValues: PaddingValues
) {
    val shows by showsLiveData.observeAsState()
    shows?.let {
        CardGridView(
            cardData = shows!!,
            onItemClick = onNavToShow,
            paddingValues
        )
    }
}

@ExperimentalFoundationApi
@Composable
fun CardGridView(
    cardData: List<Shows>,
    onItemClick: (id: Long) -> Unit,
    paddingValues: PaddingValues
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(128.dp),
        modifier = Modifier.padding(top = paddingValues.calculateTopPadding())
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