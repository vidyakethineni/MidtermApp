package com.example.midtermapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HighScoreViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ScoreRepository
    val allScores:LiveData<List<Score>>

    init {
        val scoresDao = (application as GameApplication).getScoreDao()
        repository = ScoreRepository(scoresDao)
        allScores = repository.allScoresLD
    }

    fun delete(score: Score) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(score)
        }
    }

    fun getScoreByUser(userName: String): LiveData<List<Score>> {
        return repository.getScoreByUser(userName)
    }

}

