package com.flimbis.tvserialcompose.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.flimbis.tvserialcompose.CardData

@ExperimentalFoundationApi
@Composable
fun CardGridView(cardData: List<CardData>) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(cardData) { data ->
            CardView(
                title = data.title,
                imageId = data.imageId
            )
        }
    }
}