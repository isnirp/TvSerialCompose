package com.flimbis.tvserialcompose.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.flimbis.tvserialcompose.ui.vm.ShowDetailsViewModel
import androidx.compose.runtime.getValue

@Composable
fun ShowScreen(
    showDetailsViewModel: ShowDetailsViewModel,
    id: Long?,
    paddingValues: PaddingValues
) {
    val show by showDetailsViewModel.show.observeAsState()
    /* Text(
         text = "Hello Navigation ${show?.id}",
         modifier = Modifier.padding(paddingValues.calculateTopPadding())
     )*/
    Box(
        modifier = Modifier
            .padding(paddingValues.calculateTopPadding())
            .fillMaxSize()
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = show?.image?.original,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Column(modifier = Modifier.padding(32.dp)) {
            Text(
                text = show?.name ?: "no name",
                style = MaterialTheme.typography.titleMedium
            )
            Text(text = show?.summary ?: "description")

        }
    }
}