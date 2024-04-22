package com.example.watchlist

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items

@Composable
fun WatchList(
    list: List<Movie>,
    onCheckedMovie: (Movie, Boolean) -> Unit,
    onCloseMovie: (Movie) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = list,
            key = { movie -> movie.id}
        ) {movie ->
            MovieItem(
                movieTitle = movie.title,
                checked = movie.checked,
                onCheckedChange = { checked -> onCheckedMovie(movie, checked)},
                onClose = { onCloseMovie(movie) }
            )

        }
    }
}