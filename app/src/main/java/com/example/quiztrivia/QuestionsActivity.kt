package com.example.quiztrivia

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {

    //creating global variables so that they can be used outside the function too
    private var currentPosition:Int=1
    private var num_of_crct_ans:Int=0
    //questionlist is an arrayList of type arraylist<class>
    private var questionsList:ArrayList<QuestionModel>?=null
    private var selectedOptionPosition:Int=0
    private var user_name:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        user_name=intent.getStringExtra("Username")


        questionsList=QuestionController.getQuestions()
        displayques()


        //these four are saying through this keyword that "hmara kaam hmari activity ko pta h, usse pucho"
        //so class has inherited an interface View.onClickListener which has it's memeber method,it will be called then
        //to do the task when the option is pressed
        option_one.setOnClickListener(this)
        option_two.setOnClickListener(this)
        option_three.setOnClickListener(this)
        option_four.setOnClickListener(this)
        submit_btn.setOnClickListener(this)
    }

    fun displayques()
    {
        //bcz the data type of the arrayList is class QuestionModel
        val question:QuestionModel=questionsList!![currentPosition-1]

        //so that every option has default background in the beginning itself
        optiondefaultbackground()

        if(currentPosition==questionsList!!.size)
            submit_btn.text="FINISH"

        progress_bar.progress=currentPosition
        progress_text_view.text="$currentPosition/${questionsList!!.size}"
        question_text.text=question.questionText
        option_one.text=question.optionOne
        option_two.text=question.optionTwo
        option_three.text=question.optionThree
        option_four.text=question.optionFour

    }

    fun optiondefaultbackground()
    {
        val arrayListoftv=ArrayList<TextView>()
        arrayListoftv.add(option_one)
        arrayListoftv.add(option_two)
        arrayListoftv.add(option_three)
        arrayListoftv.add(option_four)
        for(option in arrayListoftv)
        {
            option.background=ContextCompat.getDrawable(this,R.drawable.option_border)
            option.setTextColor(Color.parseColor("#000000"))

        }



        //this is code repetition, so don't do this
       /* option_one.background=ContextCompat.getDrawable(this,R.drawable.option_border)
        option_two.background=ContextCompat.getDrawable(this,R.drawable.option_border)
        option_three.background=ContextCompat.getDrawable(this,R.drawable.option_border)
        option_four.background=ContextCompat.getDrawable(this,R.drawable.option_border)*/
    }

    //it is a member of the interface View.onClickListener
    override fun onClick(v:View?) {
        // '?' bcz it is given that v is nullable
        when(v?.id)
        {
            R.id.option_one->{optionSelectedBackgrund(option_one,1)}
            R.id.option_two->{optionSelectedBackgrund(option_two,2)}
            R.id.option_three->{optionSelectedBackgrund(option_three,3)}
            R.id.option_four->{optionSelectedBackgrund(option_four,4)}
            R.id.submit_btn->{
                if(selectedOptionPosition==0)
                {
                    currentPosition=currentPosition+1;
                    when {
                        currentPosition<=questionsList!!.size->{displayques()}
                        else->{
                            val intent=Intent(this,finalactivity::class.java)
                            intent.putExtra("Username",user_name)
                            intent.putExtra("Correct_ans",num_of_crct_ans)
                            intent.putExtra("total",questionsList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }

                }
                else
                {
                    val question:QuestionModel=questionsList!![currentPosition-1]
                    if(question.correctAnswer==selectedOptionPosition)
                        num_of_crct_ans += 1

                    if(question.correctAnswer!=selectedOptionPosition){
                        redgreenhighlight(selectedOptionPosition,R.drawable.wrongans)}
                    redgreenhighlight(question.correctAnswer,R.drawable.correctans)

                    //so that it refreshes for next ques
                    selectedOptionPosition=0
                }
            }
        }


    }

    fun optionSelectedBackgrund(tv:TextView,selectedOptionNo:Int)
    {
        //so that all options turn normal before any option is selected
        optiondefaultbackground()
        selectedOptionPosition=selectedOptionNo
        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_option)
        tv.setTextColor(Color.parseColor("#ffffff"))
    }

    fun redgreenhighlight(answer:Int,drawable:Int)
    {
        when(answer)
        {
            1->{option_one.background=ContextCompat.getDrawable(this,drawable)}
            2->{option_two.background=ContextCompat.getDrawable(this,drawable)}
            3->{option_three.background=ContextCompat.getDrawable(this,drawable)}
            4->{option_four.background=ContextCompat.getDrawable(this,drawable)}
        }
    }


}