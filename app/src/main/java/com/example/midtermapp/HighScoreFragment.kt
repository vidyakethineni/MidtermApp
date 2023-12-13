
package com.example.midtermapp
import ScoreAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.midtermapp.HighScoreViewModel
import com.example.midtermapp.databinding.FragmentHighScoreBinding

class HighScoreFragment : Fragment() {
    private lateinit var viewModel: HighScoreViewModel
    private lateinit var binding: FragmentHighScoreBinding
    private lateinit var adapter: ScoreAdapter // Create an adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHighScoreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[HighScoreViewModel::class.java]
        // Set up RecyclerView and adapter
        adapter = ScoreAdapter(){score->
            Toast.makeText(requireContext(), score.toString(), Toast.LENGTH_SHORT).show()
            val dialogFragment = ConfirmDeleteDialogFragment(score){
                viewModel.delete(it)
            }
            dialogFragment.show(childFragmentManager,"DIALOG")

        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        // Observe the LiveData from ViewModel and update the adapter
        viewModel.allScores.observe(viewLifecycleOwner, Observer { scores ->
            adapter.submitList(scores)
            if (scores.isEmpty()) {
                binding.noScoresTextView.visibility = View.VISIBLE
            } else {
                binding.noScoresTextView.visibility = View.GONE
            }
        })
    }
}
