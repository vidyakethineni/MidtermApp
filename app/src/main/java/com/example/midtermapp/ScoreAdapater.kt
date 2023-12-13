import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.midtermapp.Score
import com.example.midtermapp.databinding.HighScoreItemBinding

class ScoreAdapter(private val onDeleteClicked:(Score)->Unit): ListAdapter<Score, ScoreAdapter.ScoreViewHolder>(object : DiffUtil.ItemCallback<Score>(){
    override fun areItemsTheSame(oldItem: Score, newItem: Score): Boolean {
        return oldItem.scoreUser == newItem.scoreUser
    }

    override fun areContentsTheSame(oldItem: Score, newItem: Score): Boolean {
        return oldItem == newItem
    }

}) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScoreViewHolder {
        val binding = HighScoreItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ScoreViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ScoreViewHolder, position: Int) {
        val currentScore = getItem(position)
        holder.bind(currentScore)
    }

    inner class ScoreViewHolder(private val binding: HighScoreItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(score: Score) {
            binding.deleteButton.setOnClickListener{
                onDeleteClicked(getItem(absoluteAdapterPosition))
            }
            binding.score = score
            binding.executePendingBindings()
        }
    }
}
