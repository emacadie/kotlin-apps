package info.shelfunit.tutorial


fun doSomeStuff(): Unit {
    println("Hello World from doSomeStuff!")
    var kevin = Person()
    kevin.fName = "Kevin"
    println( "Name is ${kevin.fName}" )
    kevin.fName = "Steve"
    println( "Name is now ${kevin.fName}" )

    var joe = SecondPerson( "Joe" )
    println( "Name of joe is ${joe.fName}" )
}

// class PersonRunner {
    fun main(args: Array<String>) {
        println( "args: " + args )
        println("Hello World!")
        doSomeStuff()
    }
// }
