package com.example.myapplication.domain.movie.retrofit

import com.example.myapplication.domain.movie.RemoteMovieDataSource
import com.example.myapplication.domain.movie.model.Movie
import java.lang.Exception

class RetrofitMovieDataSource(private val movieDbApi:MovieDbApi):RemoteMovieDataSource {

    override suspend fun search(query: String): Movie {
       val movieResponse = movieDbApi.search(query)
        val responseBody = movieResponse.body()
        if(movieResponse.isSuccessful && responseBody!=null){
            return responseBody.jsonResult
        }
        throw Exception(movieResponse.message())
    }
}