package com.example.rickmorty.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.rickmorty.ui.episodes.EpisodeDetailScreen
import com.example.rickmorty.ui.episodes.EpisodesListScreen

@Composable
fun AppNav() {
    // controlador que recuerda y crea la navegacion
    val navController = rememberNavController()

    // Definir rutas y el composable para cada una de las rutas
    NavHost(
        navController = navController,
        startDestination = "episodes"
    ) {

        composable("episodes") {
            EpisodesListScreen(
                onEpisodeClick = { episodeId ->
                    navController.navigate("episode/$episodeId")
                }
            )
        }


        composable(
            route = "episode/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            // Recuperar el id de la ruta
            val episodeId = backStackEntry
                .arguments?.getInt("id") ?: 0

            EpisodeDetailScreen(
                episodeId = episodeId
            )

        }

    }
}