package com.example.quiz

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username = intent.getStringExtra(Constants.user_name)
        val tv_name = findViewById<TextView>(R.id.tv_name)
        tv_name.text = username
        val totalquestion = intent.getIntExtra(Constants.total_questions,0 )
        val correctanswers = intent.getIntExtra(Constants.correct_answers,0)
        val tv_score = findViewById<TextView>(R.id.tv_score)
        tv_score.text="your score is $correctanswers out of $totalquestion"

        val btn_finish = findViewById<Button>(R.id.btn_finish)
        btn_finish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }


    }
}