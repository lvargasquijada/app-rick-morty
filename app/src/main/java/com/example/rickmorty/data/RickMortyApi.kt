package com.example.rickmorty.data

import retrofit2.http.GET
import retrofit2.http.Path

interface RickMortyApi {

    // - esta anotacion le indica a Retrofit:
    // * Cuando se llame este metodo, ejecute un HTTP GET

    // https://rickandmortyapi.com/api/episode

    // suspend:
    // * ejecutar sin bloquear el hilo principal
    @GET("episode")
    suspend fun getEspisodes() : EpisodesResponseDTO

    // https://rickandmortyapi.com/api/episode/1

    @GET(value = "episode/{id}")
    suspend fun getEpisodeById(
        @Path("id") id: Int
    ) : EpisodeDTO

    // https://rickandmortyapi.com/api/character/1
}