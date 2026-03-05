package com.example.rickmorty.ui.episodes

import androidx.lifecycle.ViewModel
import com.example.rickmorty.ui.fake.FakeEpisode
import com.example.rickmorty.ui.fake.fakeEpisodes
import com.example.rickmorty.ui.state.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class EpisodesListViewModel : ViewModel() {

    // MutableStateFlow: "estado mutable interno" que la VM actualiza
    private val _state = MutableStateFlow<UiState<List<FakeEpisode>>>(UiState.Loading)

    // StateFlow: "Estado de lectura" -> UI observa
    val state: StateFlow<UiState<List<FakeEpisode>>> = _state

    fun load() {
        // Cambiarlo por los datos de la API *******
        _state.value = UiState.Success(fakeEpisodes)
    }

}