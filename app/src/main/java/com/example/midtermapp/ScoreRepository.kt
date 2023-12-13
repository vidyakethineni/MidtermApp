package com.example.midtermapp

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ScoreRepository(private val dao: ScoreDao) {

     suspend fun getAllScores() = withContext(Dispatchers.IO) {dao.getAll()}
     val allScoresLD = dao.getAllScores()

    fun getScoreByUser(userName:String) = dao.get(userName)
    suspend fun insert(score: Score) {
        withContext(Dispatchers.IO){
            dao.insert(score)
        }

    }

   suspend fun delete(score: Score) {
        withContext(Dispatchers.IO){
            dao.delete(score)
        }
    }
}