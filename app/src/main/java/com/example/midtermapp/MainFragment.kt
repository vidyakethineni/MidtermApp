package com.example.midtermapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.midtermapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProvider(requireActivity())[GameViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        binding.playGameButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_gameFragment)
        }
        binding.viewHighScoresButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_highScoreFragment)
        }

        viewModel.getScoreByUser(viewModel.userName.value?:"").observe(viewLifecycleOwner){
            binding.welcomeTextView.setWelcomeText(it)
            binding.scoreTextView?.setSubText(it)
        }


    }
}
