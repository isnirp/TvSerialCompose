package com.flimbis.tvserialcompose.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import com.flimbis.tvserialcompose.model.Shows
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.LayoutDirection
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.flimbis.tvserialcompose.ui.vm.ShowsViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    showsViewModel: ShowsViewModel = hiltViewModel(),
    onNavToShow: (id: Long) -> Unit,
    paddingValues: PaddingValues
) {
    val shows by showsViewModel.showsUiState.observeAsState()
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
    /* LazyVerticalGrid(
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
     }*/
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(200.dp),
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        content = {
            items(cardData) { data ->
                AsyncImage(
                    model = data.image.medium,
                    contentScale = ContentScale.Crop,
                    contentDescription = data.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .clickable { onItemClick(data.id) }
                )
            }
        },
        modifier = Modifier
            .padding(top = paddingValues.calculateTopPadding())
            .fillMaxSize()
    )
}

// NB
// Use Compose's State and MutableState types to make state observable by Compose
// also; https://developer.android.com/jetpack/compose/libraries#streams