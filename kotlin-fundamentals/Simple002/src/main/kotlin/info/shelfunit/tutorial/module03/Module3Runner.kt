package info.shelfunit.tutorial.module03

import info.shelfunit.tutorial.module02.doSomeStuff
import java.io.FileReader
import java.util.TreeMap

class Module3Runner {
    fun doSomeStuff(): Unit {
        val q = Question()
        q.Answer = "22"

        q.display()
        println( "The answer to the question ${q.Question} from doSomeStuff is ${q.Answer}" )
        println( "The correct answer is ${q.CorrectAnswer}" )
        var message: String
        if ( q.Answer == q.CorrectAnswer ) {
            message = "You were correct, but not as smart as you think you are"
        } else {
            message = "Thank you for not being a mindless conformist"
        }
        println( message )
        // we could also do this:
        val message2 = if ( q.Answer == q.CorrectAnswer ) {
            "You were correct, but not as smart as you think you are"
        } else {
            "Thank you for not being a mindless conformist"
        }
        println( "Here is message2: ${message2}" )

        print( "Calling q.printResult(): "  )
        q.printResult()
        println( " " )

        val number:Int = try {
            Integer.parseInt( q.Answer )
        } catch ( e:NumberFormatException ) {
            -1
        }
        // either interpolation works
        println( "number is: ${number}" )
        println( "number is: $number" )
        var ages = TreeMap< String, Int >()
        ages[ "Kevin" ] = 55
        ages[ "Sam" ] = 24
        ages[ "Alex" ] = 24
        ages[ "Henry" ] = 26
        for ( ( name, age ) in ages ) {
            println( "$name is $age" )
        }

        var numbers = listOf( 1, 2, 3, 4, 5 )
        for ( ( index, element ) in numbers.withIndex() ) {
            println( "$element at $index" )
        }
    } // doSomeStuff

    fun workWithExceptions() {
        var reader = FileReader( "filename" )
        reader.read()

    } // workWithExceptions
}



fun main( args: Array< String > ) {
    println( "args: " + args )
    println( "Hello World! from Module3Runner" )
    val mod3 = Module3Runner()
    mod3.doSomeStuff()
    mod3.workWithExceptions()
}