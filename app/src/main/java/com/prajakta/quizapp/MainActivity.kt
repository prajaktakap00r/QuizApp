package com.prajakta.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnstart:Button=findViewById(R.id.btnStart)
        val name:EditText=findViewById(R.id.Name)
        btnstart.setOnClickListener(){
            if(name.text.isEmpty()){
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_LONG).show()
            }else{
                val intent= Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.user_name,name.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }



}