package com.example.watchlist

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WatchlistViewModel : ViewModel() {
    private val _movies = getMovies().toMutableStateList()
    val movies: List<Movie>
        get() = _movies

    fun remove(item: Movie) {
        _movies.remove(item)
    }

    fun add(item: Movie) {
        _movies.add(item)
    }

    fun changeMovieChecked(item: Movie, checked: Boolean) {
        movies.find { it.id == item.id}?.let { movie ->
            movie.checked = checked
        }
    }
}

private fun getMovies() = listOf(
    Movie(1, "Star Wars: Empire Strikes Back"),
    Movie(2, "Lord of the Rings: Fellowship of the Ring"),
    Movie(3, "Blade Runner 2049")
)