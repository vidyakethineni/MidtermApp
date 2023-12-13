package com.example.midtermapp

import android.app.Application

class GameApplication : Application() {

    private lateinit var scoreDatabase: ScoreDatabase
    override fun onCreate() {
        super.onCreate()
        scoreDatabase = ScoreDatabase.getInstance(this)
    }

    fun getScoreDao():ScoreDao{
        return scoreDatabase.scoreDao
    }

}