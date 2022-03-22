package com.alinavevel.quizapp

object Constans {

    const val USER_NAME : String = "user_name"
    const val CORRECT_ANSWER : String = "correct_answer"
    const val QUESTION_COUNT : String = "count_questions"

    fun getQuestions(): ArrayList<Question> {
        val listsOfQuestions = ArrayList<Question>()
        val question1 = Question(
            "What country is that?",
            1,
            R.drawable.armenia,
            "Russia",
            "China",
            "Germany",
            "Armenia",
            4

        )
        val question2 = Question(
            "What country is that?",
            2,
            R.drawable.belorus,
            "Belarus",
            "Armenia",
            "Moldova",
            "Russia",
            1
        )

        val question3 = Question(
            "What country is that?",
            3,
            R.drawable.georgia,
            "Cuba",
            "Austria",
            "Georgia",
            "Japan",
            3

        )

        val question4 = Question(
            "What country is that?",
            4,
            R.drawable.kazahstan,
            "Corea",
            "Kazakhstan",
            "Germany",
            "Lithuania",
            2

        )

        val question5 = Question(
            "What country is that?",
            5,
            R.drawable.russia,
            "Russia",
            "China",
            "USA",
            "Poland",
            1

        )

        val question6 = Question(
            "What country is that?",
            6,
            R.drawable.tadzikistan,
            "Iraq",
            "Iran",
            "Vietnam",
            "Tajikistan",
            4

        )

        listsOfQuestions.add(question1)
        listsOfQuestions.add(question2)
        listsOfQuestions.add(question3)
        listsOfQuestions.add(question4)
        listsOfQuestions.add(question5)
        listsOfQuestions.add(question6)

        return listsOfQuestions
    }
}