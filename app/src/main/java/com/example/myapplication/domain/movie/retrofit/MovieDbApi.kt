package com.example.myapplication.domain.movie.retrofit

import com.example.myapplication.domain.movie.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDbApi {

    @GET("/")
    suspend fun search(@Query("t") query: String): Response<MovieResponse>
}