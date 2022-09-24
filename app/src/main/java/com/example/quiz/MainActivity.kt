package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val button = findViewById<Button>(R.id.btn_start)
        val et_name = findViewById<TextView>(R.id.et_name)
        button.setOnClickListener {

            if(et_name.text.toString().isEmpty()){
                Toast.makeText(this,
                    "please enter your name", Toast.LENGTH_SHORT).show()
            }else{
                val intent= Intent(this, QuizQuestionActivity::class.java)
                intent.putExtra(Constants.user_name,et_name.text.toString())
                startActivity(intent)
                finish()
            }
        }


    }
}