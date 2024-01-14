package com.example.myapplication.domain.movie

import com.example.myapplication.domain.movie.model.Movie

interface RemoteMovieDataSource {

    suspend fun search(query: String): Movie
}