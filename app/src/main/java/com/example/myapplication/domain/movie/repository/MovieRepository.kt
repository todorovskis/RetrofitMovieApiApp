package com.example.myapplication.domain.movie.repository

import com.example.myapplication.domain.movie.RemoteMovieDataSource
import com.example.myapplication.domain.movie.model.Movie

class MovieRepository(private val remoteMovieDataSource: RemoteMovieDataSource) {

    suspend fun queryMovie(query: String): Movie {
        return remoteMovieDataSource.search(query)
    }
}