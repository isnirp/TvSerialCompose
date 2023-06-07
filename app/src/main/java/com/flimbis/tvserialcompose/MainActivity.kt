package com.flimbis.tvserialcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.flimbis.tvserialcompose.ui.TvSerialNavigation
import com.flimbis.tvserialcompose.ui.theme.TvSerialComposeTheme
import com.flimbis.tvserialcompose.ui.vm.ShowsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val viewModel = ViewModelProvider(this).get(ShowsViewModel::class.java)

        setContent {
            TvSerialComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    val viewModel: ShowsViewModel by viewModels()
                    val viewModel: ShowsViewModel = hiltViewModel()

                    TvSerialNavigation(showsLiveData = viewModel.showsUiState)
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
            color = MaterialTheme.colorScheme.background
        ) {
        }
    }
}