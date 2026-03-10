package com.example.rickmorty.ui.episodes

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.rickmorty.ui.state.UiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EpisodeDetailScreen(
    episodeId: Int,
) {

    val vm = remember { EpisodeDetailViewModel() }

    val state by vm.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        vm.loadDetail(episodeId)
    }


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalle del episodio") },
            )
        }
    ) {
        paddingValues ->

        Column(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        ) {

            when (val currentState = state) {
                is UiState.Error -> Text("Error")
                UiState.Loading -> Text("Cargando...")
                is UiState.Success -> {
                    LazyColumn(
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ){
                        item {
                            Text(currentState.data.name)
                            Text("Episodio: ${currentState.data.episode}")
                            Text("Cantidad personajes: ${currentState.data.characters.size}")
                        }
                        items(currentState.data.characters) { per ->
                            Text(per)
                        }
                    }
                }
            }

        }
    }
}