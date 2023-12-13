package com.example.midtermapp

import android.app.Application
import android.content.Context
import android.text.TextUtils
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.util.Random

class GameViewModel(private val application: Application) : AndroidViewModel(application) {
   private val  repository: ScoreRepository
    init {
     val dao = (application as GameApplication )   .getScoreDao()
        repository = ScoreRepository(dao)

    }
    fun getScoreByUser(userName:String) = repository.getScoreByUser(userName)


    private val _attempts = MutableLiveData<Int>(0)
    val attempts: LiveData<Int> = _attempts


    val userName = MutableLiveData("")
    val guessNumber = MutableLiveData("")
    fun addToGuess(addedBy:Int){
        if(!guessNumber.value.isNullOrBlank())
           guessNumber.value = (guessNumber.value.toString().toInt()+addedBy).toString()
    }



    fun onOkClicked(context:Context){
        if(userName.value.isNullOrBlank()){
            Toast.makeText(context, "Enter valid userName!", Toast.LENGTH_SHORT).show()
            return
        }
        if(guessNumber.value.isNullOrBlank()){
            Toast.makeText(context, "Enter guess number!", Toast.LENGTH_SHORT).show()
            return
        }
       val randomNumber = Random().nextInt(100)+1
        if(guessNumber.value.toString().toInt()>randomNumber) {
            Toast.makeText(context, "Guess is higher", Toast.LENGTH_SHORT).show()
            _attempts.value = _attempts.value?.plus(1)
            playSound()
            return
        }
        if(guessNumber.value.toString().toInt()<randomNumber) {
            Toast.makeText(context, "Guess is lower", Toast.LENGTH_SHORT).show()
            _attempts.value = _attempts.value?.plus(1)
            playSound()
            return
        }

        viewModelScope.launch {
            val scoreRecord = repository.getAllScores().filter { it.scoreUser == userName.value }
            if(scoreRecord.isEmpty()){
                repository.insert(Score(userName.value?:"",_attempts.value?:0,1))
            }else{
                scoreRecord[0].scoreUser
                repository.insert(Score( scoreRecord[0].scoreUser,
                    (scoreRecord[0].scoreGuesses?.plus(_attempts.value?:0))?:0,
                    scoreRecord[0].score+1
                    ))
            }
            _insertedSuccess.value = true
        }

    }
    private val _insertedSuccess = MutableLiveData<Boolean?>(null)
    val insertedSuccess:LiveData<Boolean?> = _insertedSuccess

    private fun playSound() {

    }


    // Initialize with a random number and reset attempts
    fun resetGame() {
        _attempts.value = 0
        // Other game reset logic
    }

    fun recordAttempt(isCorrect: Boolean) {
        if (isCorrect) {
            // Logic for correct guess
        } else {
            _attempts.value = (_attempts.value ?: 0) + 1
        }
    }
}