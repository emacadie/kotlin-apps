package info.shelfunit.tutorial.module07

import java.util.*

interface Process {
    fun execute( value : Int )
}

class Program {
    fun fibonacci( limit : Int, action : ( Int ) -> Unit ) {
        println( "Starting fibonacci w/function with limit of $limit" )
        var prev = 0
        var prevprev = 0
        var current = 1
        for ( i : Int in 1..limit ) {
            action( current )
            var temp = current
            prevprev = prev
            prev = temp
            current = prev + prevprev
        }
    }

    fun fibonacci( limit : Int, action : Process ) {
        println( "Starting fibonacci w/Process with limit of $limit" )
        var prev = 0
        var prevprev = 0
        var current = 1
        for ( i : Int in 1..limit ) {
            action.execute( current )
            var temp = current
            prevprev = prev
            prev = temp
            current = prev + prevprev
        }
    }

    fun fibonacci( limit : Int ) {
        println( "Starting plain fibonacci with limit of $limit" )
        var prev = 0
        var prevprev = 0
        var current = 1
        for ( i : Int in 1..limit ) {
            println( "current is: $current"  )
            var temp = current
            prevprev = prev
            prev = temp
            current = prev + prevprev
        }
    }


} // end class Program

class Module07Runner {
}

fun useFibonacci() {
    println( "In useFibonacci" )
    var program = Program()
    /*
    println( "orig" )
    program.fibonacci( 8 )
    println( "using an anonymous class" )
    program.fibonacci( 8, object : Process {
        override fun execute( value: Int ) {
            println( "Value is $value" )
        }
    } )
    println( "using higher order functions" )
    program.fibonacci( 8, { n -> println( "Here is n: $n" ) } )
    println( "using higher order functions and putting lambda outside the other param" )
    program.fibonacci( 8 ) { n -> println( "Here is n: $n" ) }
    println( "using higher order functions and using it" )
    program.fibonacci( 8 ) { println( "Here is n: $it" ) }
    println( "using higher order functions and using function reference" )
    program.fibonacci( 8, ::println )
    */

    var total = 0
    // using closure
    program.fibonacci( 8 ) { it -> total += it }
    println( "total is: $total" )
} // useFibonacci

class Meeting {
    var Title : String = ""
    var When : Date = Date()
    var Who = mutableListOf< String >()

    override fun toString() : String {
        return "Title: $Title, When: $When, Who: $Who"
    }

    fun create( ) {
        println( "Calling create" )
    }
}

fun workWithMeeting() {
    println( "In function workWithMeeting" )
    val m = Meeting()
    m.Title = "Board Meeting"
    m.When = Date()
    m.Who.add( "Kevin" )
    println( "m.toString() constructed in usual way: ${m.toString()}" )
    // could also do
    val m2 = Meeting()
    with ( m2 ) {
        Title = "Longer Board Meeting"
        When = Date()
        Who.add( "George" )
    }
    // Groovy would do m.with{}
    println( "m2.toString created using 'with': ${m2.toString()}" )
    val m3 = Meeting()
    m3.apply {
        Title = "Holy Cow, another meeting"
        When = Date()
        Who.add( "John Adams" )
    }.create()
    println( "m3.toString created using 'apply': ${m3.toString()}" )
}

fun main( args : Array< String > ) {
    println( "Hello from Module07Runner" )
    // useFibonacci()
    workWithMeeting()
}

