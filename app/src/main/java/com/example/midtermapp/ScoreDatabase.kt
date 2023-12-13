package com.example.midtermapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


/**
 * Database class to manage and provide access to the Score entities
 */
@Database(entities = [Score::class], version = 1, exportSchema = false)
abstract class ScoreDatabase : RoomDatabase() {
    /**
     * Abstract function to retrieve the Score Data Access Object (DAO)
     */
    abstract val scoreDao: ScoreDao
    /**
     * Companion object holding a singleton instance of the database
     */
    companion object {
        @Volatile
        private var INSTANCE: ScoreDatabase? = null
        /**
         * Retrieves a singleton instance of the database
         */
        fun getInstance(context: Context): ScoreDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ScoreDatabase::class.java,
                        "scores_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}