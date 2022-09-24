package com.example.quiz

object Constants {


    const val user_name: String ="user_name"
    const val total_questions : String ="total_question"
    const val correct_answers : String ="correct_answer"
    fun getQuestions(): ArrayList<Question> {
        val questionList = ArrayList<Question>()

        val que1 = Question(
            1, "What do i talk on phone the most?",

            "about food that i ate",
            "bitching about the person i hate",
            "about my hair fall",
            "i don't talk on phone usually",
            2


        )

        questionList.add(que1)

        val que2 = Question(
            2, "what food i hate the most?",

            "bhindi",
            "rajma",
            "bottle gourd(aka lauki)",
            "karella",
            1


        )
        questionList.add(que2)
        val que3 = Question(
            3, "why i say ki tum mere best friend ho ???",

            "itne limited tym me hi tum mujhe kafi ache se smjhte hoo",
            " kyuki tum good listner ho",
            "you are overthinker  mere jaseee",
            "perfect bahu quality hai tume",
            1


        )
        questionList.add(que3)

        val que4 = Question(
            4, "my celebrity crush",

            "vicky kaushal",
            "vijay D",
            "Sahid kapoor",
            "none",
            2



        )
        questionList.add(que4)

        val que5 = Question(
            5, "one word use to describe me",

            "weird",
            "sweet",
            "irritating",
            "chill",
            3


        )
        questionList.add(que5)

        val que6 = Question(
            6, "my fav sport",

            "cricket",
            "basketball",
            "badminton",
            "football",
            3


        )
        questionList.add(que6)

        val que7 = Question(
            7, "what i m really good at",

            "singing",
            "dancing",
            "technology",
            "bakchodi",
            4


        )
        questionList.add(que7)

        val que8 = Question(
            2, "What describe my kind of man",

            "can control my mood swings,anger,irritating behaviour",
            "patience",
            "good cooker",
            "all above",
            4


        )
        questionList.add(que8)

        val que9 = Question(
            9, "where will i spend money from lottery",

            "travelling",
            "food",
            "dresses",
            "charity",
            3


        )
        questionList.add(que9)


        val que10 = Question(
            10, "if i am sad what things can u do to make me happy",

            "showing me memes/standup",
            "talking wid me",
            "playing my fav track",
            "bringing me food",
            2


        )
        questionList.add(que10)







        return questionList

    }

}