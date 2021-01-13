import info.shelfunit.tutorial.Person
import info.shelfunit.tutorial.SecondPerson

fun main(args: Array<String>) {
    println("Hello World!")
    var kevin = Person()
    kevin.fName = "Kevin"
    println( "Name is ${kevin.fName}" )
    kevin.fName = "Steve"
    println( "Name is now ${kevin.fName}" )

    var joe = SecondPerson( "Joe" )
    println( "Name of joe is ${joe.fName}" )
}
