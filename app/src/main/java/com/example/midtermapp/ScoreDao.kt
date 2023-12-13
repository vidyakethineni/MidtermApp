package com.example.midtermapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


/**
 * Data Access Object (DAO) for managing Score entities in the database
 */
@Dao
interface ScoreDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(score: Score)
    @Update
    suspend fun update(score: Score)
    @Delete
    suspend fun delete(score: Score)
    /**
     * Retrieves a specific Score by its unique identifier
     */
    @Query("SELECT * FROM score_table WHERE  score_user= :name limit 1")
    fun get(name: String): LiveData<List<Score>>
    /**
     * Retrieves all Scores from the database in ascending order by guessed
     */
    @Query("SELECT * FROM score_table ORDER BY score_guesses ASC")
    suspend fun getAll(): List<Score>

    @Query("SELECT * FROM score_table ORDER BY score_guesses ASC")
     fun getAllScores(): LiveData<List<Score>>
}