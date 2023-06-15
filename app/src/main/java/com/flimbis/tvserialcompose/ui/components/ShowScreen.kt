package com.flimbis.tvserialcompose.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ShowScreen(
    id: Long,
    paddingValues: PaddingValues,
    onShowDetails: () -> Unit
) {
    Text(
        text = "Hello Navigation $id",
        modifier = Modifier.padding(paddingValues.calculateTopPadding())
    )
    Box(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Column(modifier = Modifier.padding(32.dp)) {
            Text(
                text = "title",
                style = MaterialTheme.typography.titleMedium
            )
            Text(text = "description")

        }
    }
}