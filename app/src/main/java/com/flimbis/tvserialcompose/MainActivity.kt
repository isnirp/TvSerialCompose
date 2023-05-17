package com.flimbis.tvserialcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import com.flimbis.tvserialcompose.ui.components.CardGridView
import com.flimbis.tvserialcompose.ui.theme.TvSerialComposeTheme
import com.flimbis.tvserialcompose.ui.vm.ShowsViewModel

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: ShowsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TvSerialComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TvSerialComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            val cardData = listOf(
                CardData("Title 1", R.drawable.ic_launcher_background),
                CardData("Title 2", R.drawable.ic_launcher_foreground),
                CardData("Title 3", R.drawable.ic_launcher_background),
                CardData("Title 4", R.drawable.ic_launcher_foreground),
                CardData("Title 5", R.drawable.ic_launcher_background)
            )

            CardGridView(cardData)
        }
    }
}

data class CardData(val title: String, val imageId: Int)