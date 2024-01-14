package com.example.myapplication.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.myapplication.R
import com.example.myapplication.databinding.SecondFragmentBinding
import com.example.myapplication.viewmodels.MovieIdViewModel

class SecondFragment : Fragment(R.layout.second_fragment) {

    private var _binding: SecondFragmentBinding? = null
    private val binding get() = _binding!!
    private val movieIdViewModel : MovieIdViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = SecondFragmentBinding.bind(view)

        movieIdViewModel.text.observe(viewLifecycleOwner){
            binding.movieid.text = it
        }
    }
}