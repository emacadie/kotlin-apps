import info.shelfunit.tutorial.module02.Person
import info.shelfunit.tutorial.module02.SecondPerson


fun newDisplay( message: String ) : Boolean {
    println( message )
    return true
}

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
