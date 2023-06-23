package com.prajakta.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(),View.OnClickListener {

    private var mCurrentPosition:Int=1
    private var mQuestionList:ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int=0
    private var mCorrectAnswers:Int=0

    private var mUserName:String?=null
    private var progressbar: ProgressBar?= null
    private var progress:TextView?=null
    private var tvquestion:TextView?=null
    private var img: ImageView?=null

    private var optionOne:TextView?=null
    private var optionTwo:TextView?=null
    private var optionThree:TextView?=null
    private var optionFour:TextView?=null
    private var btnSubmit:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressbar=findViewById(R.id.progressBar)
        progress=findViewById(R.id.progressText)
        mUserName=intent.getStringExtra(Constants.user_name)
        tvquestion=findViewById((R.id.tvQuestion))
        img=findViewById(R.id.img)
        optionOne=findViewById(R.id.optionOne)
        optionTwo=findViewById(R.id.optionTwo)
        optionThree=findViewById(R.id.optionThree)
        optionFour=findViewById(R.id.optionFour)
        btnSubmit=findViewById(R.id.btn)
        optionOne?.setOnClickListener(this)
        optionTwo?.setOnClickListener(this)
        optionThree?.setOnClickListener(this)
        optionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)


        mQuestionList = Constants.getQuestions()
        setQuestion()

    }

    private fun setQuestion() {
        defaultOptionView()
        val question: Question = mQuestionList!![mCurrentPosition-1]
        img?.setImageResource(question.image)
        progressbar?.progress = mCurrentPosition
        progress?.text = "${mCurrentPosition}/${progressbar?.max}"
        tvquestion?.text = question.question
        optionOne?.text = question.optionOne
        optionTwo?.text = question.optionTwo
        optionThree?.text = question.optionThree
        optionFour?.text = question.optionFour
        if(mCurrentPosition==mQuestionList!!.size){
            btnSubmit?.text="FINISH"
        }else{
            btnSubmit?.text="SUBMIT"
        }

        }
    private fun defaultOptionView(){
        val options=ArrayList<TextView>()
        optionOne?.let{
            options.add(0,it)
        }
        optionTwo?.let{
            options.add(1,it)
        }
        optionThree?.let{
            options.add(2,it)
        }
        optionFour?.let{
            options.add(3,it)
        }
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.bg)
        }

    }
    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptionView()
        mSelectedOptionPosition=selectedOptionNum
        tv.setTextColor(Color.parseColor("#363a43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_option)
    }


    override fun onClick(view: View?) {
        when(view?.id){
            R.id.optionOne ->{
                optionOne?.let{
                    selectedOptionView(it,1)
                }
            }
            R.id.optionTwo ->{
                optionTwo?.let{
                    selectedOptionView(it,2)
                }
            }
            R.id.optionThree ->{
                optionThree?.let{
                    selectedOptionView(it,3)
                }
            }
            R.id.optionFour ->{
                optionFour?.let{
                    selectedOptionView(it,4)
                }
            }
            R.id.btn -> {
                if(mSelectedOptionPosition == 0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else->{
                            val intent=Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.user_name,mUserName)
                            intent.putExtra(Constants.correct_ans,mCorrectAnswers)
                            intent.putExtra(Constants.total_questions,mQuestionList?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if(question!!.correctAns != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_selected_option)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAns, R.drawable.correct_selected_option)
                    if(mCurrentPosition== mQuestionList!!.size){
                        btnSubmit?.text="FINISH"
                    }else{
                        btnSubmit?.text="GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition=0
                }
            }

        }
    }
    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1->{
                optionOne?.background=ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                optionTwo?.background=ContextCompat.getDrawable(this,drawableView)
            }
            3->{
                optionThree?.background=ContextCompat.getDrawable(this,drawableView)
            }
            4->{
                optionFour?.background=ContextCompat.getDrawable(this,drawableView)
            }

        }
    }
}