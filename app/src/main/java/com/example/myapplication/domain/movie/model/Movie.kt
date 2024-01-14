package com.example.myapplication.domain.movie.model

import com.google.gson.annotations.SerializedName

data class Movie(@SerializedName("Title") var title:String,
                 @SerializedName("imdbID") var imdbId: String,
                 @SerializedName("Poster") var poster: String,
                 @SerializedName("Year") var year: Int) {
}