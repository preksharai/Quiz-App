package com.example.quiztrivia

//controller file to create the object of the class
//need to import questionModel file first so that it could be used here, or not bcz the files are in same package

//just created an object, it has no class. It has a function returning an arraylist having collection of objects
object QuestionController {

    fun getQuestions():ArrayList<QuestionModel> {

        //array list of type class
        val questionList = ArrayList<QuestionModel>()

        val q1 = QuestionModel(1, "What is the part of a database that holds only one type of information",
            "Report", "Field", "Record", "File", 2)
        val q2 = QuestionModel(2, "What is the full form of OS in Computer Sience", "Order of Significance",
            "Open Software", "Operating System", "Optical Sensor", 3)
        val q3 = QuestionModel(3, "Which among these is a JS library","ReactJs","Laravel",
        "Django","Android",1)
        val q4=QuestionModel(4,"How to pass the data between activities in Android?","Intent","Content Provider",
        "Broadcast Receiver","None of the above.",1)
        val q5=QuestionModel(5," Is it mandatory to call onCreate() and onStart() in android?",
        "No, we can write the program without writing onCreate() and onStart()"," Yes, we should call onCreate() and onStart() to write the program",
        " At least we need to call onCreate() once","None of the above",1)
        val q6=QuestionModel(6,"Which company developed android?","Apple","Google",
        "Android Inc","Nokia",3)
        val q7=QuestionModel(7,"Which is the latest language used in Android ?","Java","Kotlin",
        "C","Python",2)
        val q8=QuestionModel(8,"In which directory XML layout files are stored?",
        "/assets","/src","/res/values","/res/layout",4)
        val q9=QuestionModel(9,"Action bar can be associated to?","only fragments","only activities",
        " Both Activities And Fragments","None of the above",2)
        val q10=QuestionModel(10,"What is an interface in android?","It is a class","Interface acts as a bridge between class and the outside world.",
        "It is a layout file.","All of the above",2)

        questionList.add(q1)
        questionList.add(q2)
        questionList.add(q3)
        questionList.add(q4)
        questionList.add(q5)
        questionList.add(q6)
        questionList.add(q7)
        questionList.add(q8)
        questionList.add(q9)
        questionList.add(q10)
        return questionList
    }
}

