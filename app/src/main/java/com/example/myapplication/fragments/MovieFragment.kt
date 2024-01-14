package com.example.myapplication.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.MovieAdapter
import com.example.myapplication.R
import com.example.myapplication.databinding.FirstFragmentBinding
import com.example.myapplication.viewmodels.MovieViewModel

class MovieFragment : Fragment(R.layout.first_fragment) {

    private var _binding: FirstFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var movieViewModel: MovieViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FirstFragmentBinding.bind(view)

        val viewModelFactory = MovieViewModelFactory(requireContext())
        movieViewModel = ViewModelProvider(this, viewModelFactory)[MovieViewModel::class.java]

        val adapter: MovieAdapter = MovieAdapter()
        binding.moviesList.adapter = adapter

        movieViewModel.getMovieLiveData().observe(viewLifecycleOwner) {
            adapter.updateMovie(it)
        }

        binding.btnSearch.setOnClickListener {
//            Log.d("ss", "aaaaaa");
            // tocno e procitam stringot
//            println(binding.editTextView.text.toString())
            movieViewModel.search(binding.editTextView.text.toString())
        }
    }

}