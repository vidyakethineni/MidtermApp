package com.example.midtermapp

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("setWelcomeText")
fun TextView.setWelcomeText(scoreList:List<Score>?){
 if(scoreList.isNullOrEmpty()){
     text = "Welcome to the game"
 }else{
     text = scoreList[0].scoreUser + "score: " + scoreList[0].score
 }
}

@BindingAdapter("setSubText")
fun TextView.setSubText(scoreList:List<Score>?){
    if(scoreList.isNullOrEmpty()){
        text = ""
    }else{
        text = "Play Another Game?"
    }
}
