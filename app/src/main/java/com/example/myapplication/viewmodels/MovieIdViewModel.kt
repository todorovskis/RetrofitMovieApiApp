package com.example.myapplication.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MovieIdViewModel : ViewModel() {

    private val mutableText = MutableLiveData<String>()

    val text: LiveData<String> get() = mutableText

    fun setText(text: String) {
        mutableText.value = text
    }
}