package com.example.quiztrivia

//model file just to create the structure of the quiz questions, means variables
//if we use data class,then we don't have to create getter and setter for each varaible, otherwise have to create many of it
//variables are given in primary constructor so that it is compulsory to give the values to all of them
data class QuestionModel(
    val id:Int,
    val questionText:String,
    val optionOne:String,
    val optionTwo:String,
    val optionThree:String,
    val optionFour:String,
    val correctAnswer:Int
)

//when you'll create an object of this class then you can give values to these variables
//means creating a question actually
