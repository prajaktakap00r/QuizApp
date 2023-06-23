package com.prajakta.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val name:TextView=findViewById(R.id.name)
        val score:TextView=findViewById(R.id.score)
        val btnFinish: Button =findViewById(R.id.btnFinish)

        name.text=intent.getStringExtra(Constants.user_name)
        val totalQuestion=intent.getIntExtra(Constants.total_questions,0)
        val correctAns=intent.getIntExtra(Constants.correct_ans,0)
        score.text="Your score is $correctAns out of $totalQuestion"
        btnFinish.setOnClickListener(){
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}