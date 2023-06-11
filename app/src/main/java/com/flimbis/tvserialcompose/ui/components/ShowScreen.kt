package com.flimbis.tvserialcompose.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier

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
    LaunchedEffect(true) {
        onShowDetails
    }
}