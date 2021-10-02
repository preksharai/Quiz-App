package com.example.quiztrivia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_finalactivity.*
import kotlinx.android.synthetic.main.activity_main.*

class finalactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finalactivity)

        val username =intent.getStringExtra("Username")
        user_name.text=username
        val total=intent.getIntExtra("total",10)
        val correct=intent.getIntExtra("Correct_ans",0)
        user_score.text="Your score is $correct out of $total."
        finish_btn.setOnClickListener{
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}