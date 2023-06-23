package com.prajakta.quizapp

object Constants {

    const val user_name:String="user_name"
    const val total_questions:String="total questions"
    const val correct_ans:String="correct answers"





    fun getQuestions():ArrayList<Question>{
        val questionsList=ArrayList<Question>()


        val que1=Question(
            1,"which country this flag belong to?",R.drawable.ic_flag_of_germany,
            "Argentina","Germany","India","None",2
        )

        questionsList.add(que1)
        val que2=Question(
            2,"which country this flag belong to?",R.drawable.ic_flag_of_argentina,
            "Argentina","Russia","India","None",1
        )
        questionsList.add(que2)
        val que3=Question(
            3,"which country this flag belong to?",R.drawable.ic_flag_of_kuwait,
            "Kuwait","Russia","India","None",1
        )
        questionsList.add(que3)
        val que4=Question(
            4,"which country this flag belong to?",R.drawable.ic_flag_of_fiji,
            "Argentina","Russia","Fiji","None",3
        )
        questionsList.add(que4)
        val que5=Question(
            5,"which country this flag belong to?",R.drawable.ic_flag_of_denmark,
            "Belgium","Russia","India","Denmark",4
        )
        questionsList.add(que5)
        val que6=Question(
            6,"which country this flag belong to?",R.drawable.ic_flag_of_brazil,
            "Austria","Russia","Brazil","None",3
        )
        questionsList.add(que6)
        val que7=Question(
            7,"which country this flag belong to?",R.drawable.ic_flag_of_india,
            "France","Russia","India","None",3
        )
        questionsList.add(que7)
        val que8=Question(
            8,"which country this flag belong to?",R.drawable.ic_flag_of_belgium,
            "Belgium","Russia","India","None",1
        )
        questionsList.add(que8)
        val que9=Question(
            9,"which country this flag belong to?",R.drawable.ic_flag_of_new_zealand,
            "SriLanka","NewZealand","India","None",2
        )
        questionsList.add(que9)
        val que10=Question(
            10,"which country this flag belong to?",R.drawable.ic_flag_of_australia,
            "Indonesia","Russia","India","Australia",4
        )
        questionsList.add(que10)
        return questionsList
    }
}