package com.example.quiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener{

    private var mCurrentPosition:Int =1
    private var mQuestionsList:ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int =0
    private var mCorrectAnswers: Int =0
    private var mUsername : String? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        mUsername = intent.getStringExtra(Constants.user_name)

         mQuestionsList= Constants.getQuestions()
         setQuestion()

        val tv_option_one=findViewById<TextView>(R.id.tv_option_one)
        val tv_option_two=findViewById<TextView>(R.id.tv_option_two)
        val tv_option_three=findViewById<TextView>(R.id.tv_option_three)
        val tv_option_four=findViewById<TextView>(R.id.tv_option_four)
        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        val btn_submit = findViewById<Button>(R.id.btn_submit)
        btn_submit.setOnClickListener(this)











    }

    private fun setQuestion(){
        val btn_submit = findViewById<Button>(R.id.btn_submit)



        val question = mQuestionsList!![mCurrentPosition-1]
        defaultoptionview()
        if(mCurrentPosition == mQuestionsList!!.size){
            btn_submit.text = "FINISH"
        }else{
            btn_submit.text ="SUBMIT"

        }
        val progressbar= findViewById<ProgressBar>(R.id.progressbar)
        progressbar.progress = mCurrentPosition
        val tv_progress=findViewById<TextView>(R.id.tv_progress)
        tv_progress.text = "$mCurrentPosition" + "/" + progressbar.max


        val tv_questions=findViewById<TextView>(R.id.tv_questions)
        tv_questions.text=question!!.question
        val tv_option_one=findViewById<TextView>(R.id.tv_option_one)
        val tv_option_two=findViewById<TextView>(R.id.tv_option_two)
        val tv_option_three=findViewById<TextView>(R.id.tv_option_three)
        val tv_option_four=findViewById<TextView>(R.id.tv_option_four)
        tv_option_one.text=question.optionOne
        tv_option_two.text=question.optionTwo
        tv_option_three.text=question.optionThree
        tv_option_four.text=question.optionFour
    }
    private fun defaultoptionview(){
        val options= ArrayList<TextView>()
        val tv_option_one=findViewById<TextView>(R.id.tv_option_one)
        val tv_option_two=findViewById<TextView>(R.id.tv_option_two)
        val tv_option_three=findViewById<TextView>(R.id.tv_option_three)
        val tv_option_four=findViewById<TextView>(R.id.tv_option_four)
        options.add(0, tv_option_one)
        options.add(1, tv_option_two)
        options.add(2, tv_option_three)
        options.add(3,tv_option_four)

        for(option in options){
            option.setTextColor(Color.parseColor("#000000"))
            option.typeface = Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(
                    this,
                    R.drawable.default_option_border_bg
            )
        }



    }

    override fun onClick(v: View?) {
        val tv_option_one=findViewById<TextView>(R.id.tv_option_one)
        val tv_option_two=findViewById<TextView>(R.id.tv_option_two)
        val tv_option_three=findViewById<TextView>(R.id.tv_option_three)
        val tv_option_four=findViewById<TextView>(R.id.tv_option_four)
        val btn_submit = findViewById<Button>(R.id.btn_submit)
        when(v?.id){
            R.id.tv_option_one ->{
                SelectedOptionView(tv_option_one,1
                )
            }
            R.id.tv_option_two ->{
                SelectedOptionView(tv_option_two,2 )
            }
            R.id.tv_option_three ->{
                SelectedOptionView(tv_option_three,3)
            }
            R.id.tv_option_four ->{
                SelectedOptionView(tv_option_four,4)
            }
            R.id.btn_submit ->{
                if(mSelectedOptionPosition==0){
                    mCurrentPosition ++


                    when{
                        mCurrentPosition <= mQuestionsList !!.size ->{
                            setQuestion()
                        }else ->{
                           val intent = Intent(this, ResultActivity::class.java)
                           intent.putExtra(Constants.user_name, mUsername)
                           intent.putExtra(Constants.correct_answers, mCorrectAnswers)
                           intent.putExtra(Constants.total_questions, mQuestionsList!!.size)
                           startActivity(intent)

                    }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition -1 )
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition==mQuestionsList!!.size){
                        btn_submit.text = "FINISH"

                    }else{
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition =0

                }

            }




        }

    }
    private fun answerView(answer:Int, drawableView:Int){
        val tv_option_one=findViewById<TextView>(R.id.tv_option_one)
        val tv_option_two=findViewById<TextView>(R.id.tv_option_two)
        val tv_option_three=findViewById<TextView>(R.id.tv_option_three)
        val tv_option_four=findViewById<TextView>(R.id.tv_option_four)
        val btn_submit = findViewById<Button>(R.id.btn_submit)
        when(answer){
            1->{tv_option_one.background= ContextCompat.getDrawable(
                    this, drawableView
            )

            }
            2 ->{tv_option_two.background=ContextCompat.getDrawable(
                    this,drawableView
            )
            }
            3-> {tv_option_three.background=ContextCompat.getDrawable(
                    this,drawableView
            )}
            4 ->{tv_option_four.background=ContextCompat.getDrawable(
                    this,drawableView
            )}
        }
    }

    private fun SelectedOptionView(tv: TextView,
                                   selectedOptionNum:Int) {
        defaultoptionview()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#FF03DAC5"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background= ContextCompat.getDrawable(
                this,
                R.drawable.select_option_border_bg)
    }
}