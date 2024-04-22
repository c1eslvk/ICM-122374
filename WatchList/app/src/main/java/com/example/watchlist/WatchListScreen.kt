package com.example.watchlist

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun WatchListScreen(
    modifier: Modifier = Modifier,
    watchlistViewModel: WatchlistViewModel = viewModel()
) {
    Column (modifier = modifier) {

        AddMovieRow(
            onAddMovie = { title ->
                val newMovie =  Movie(watchlistViewModel.movies.size + 1, title)
                watchlistViewModel.add(newMovie)
            }
        )

        WatchList(
            list = watchlistViewModel.movies,
            onCheckedMovie = { movie, checked ->
                watchlistViewModel.changeMovieChecked(movie, checked)
            },
            onCloseMovie = { movie ->
                watchlistViewModel.remove(movie)
            }
        )
    }
}