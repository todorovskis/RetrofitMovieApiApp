package com.example.myapplication.fragments

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.domain.movie.repository.MovieRepository
import com.example.myapplication.domain.movie.retrofit.MovieDbApiProvider
import com.example.myapplication.domain.movie.retrofit.RetrofitMovieDataSource

class MovieViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        //instanca na movie viewmodel
        return modelClass.getConstructor(MovieRepository::class.java)
            .newInstance(MovieRepository(RetrofitMovieDataSource(MovieDbApiProvider.getMovieDbApi())))

    }
}