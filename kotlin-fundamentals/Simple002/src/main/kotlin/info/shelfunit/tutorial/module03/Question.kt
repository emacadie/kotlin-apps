package info.shelfunit.tutorial.module03

class Question {
    var Answer: String = ""
    val CorrectAnswer = "42"
    // will this be a problem? Question.Question
    val Question: String = "What is the answer?"

    fun display() {
        println( "You said " + Answer )
        println( "Kotlin style: You said $Answer" )
    }

    fun printResult() {
        /* ORIG
        if ( Answer == CorrectAnswer ) {
            print( "You are correct" )
        } else {
            print( "Try again" )
        }
         */
        when ( Answer ) {
            CorrectAnswer -> print( "You are correct, sir" )
            else -> {
                print( "Try again" )
                print( "; we can do multiple lines" )
            }
        }
    }

}