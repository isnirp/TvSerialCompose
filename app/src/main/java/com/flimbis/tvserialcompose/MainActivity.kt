package com.flimbis.tvserialcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.flimbis.tvserialcompose.ui.components.ShowsScreen
import com.flimbis.tvserialcompose.ui.theme.TvSerialComposeTheme
import com.flimbis.tvserialcompose.ui.vm.ShowsViewModel

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: ShowsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: ShowsViewModel = ViewModelProvider(this).get(ShowsViewModel::class.java)

        setContent {
            TvSerialComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ShowsScreen(viewModel.showsUiState)
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
        }
    }
}