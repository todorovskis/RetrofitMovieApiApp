package com.example.myapplication.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.movie.model.Movie
import com.example.myapplication.domain.movie.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    private val movieLiveData = MutableLiveData<Movie>()

    fun getMovieLiveData(): LiveData<Movie> = movieLiveData

    fun search(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val movie = movieRepository.queryMovie(query)
            movieLiveData.postValue(movie)
        }
    }
}