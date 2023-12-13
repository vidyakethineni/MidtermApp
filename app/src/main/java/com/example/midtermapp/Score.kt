package com.example.midtermapp
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entity class representing a Score in the database
 */
@Entity(tableName = "score_table")
data class Score(
    @PrimaryKey
    @ColumnInfo(name = "score_user")
    var scoreUser: String = "",
    @ColumnInfo(name = "score_guesses")
    var scoreGuesses: Int = 0,
    @ColumnInfo(name = "score")
var score: Int = 0
)



