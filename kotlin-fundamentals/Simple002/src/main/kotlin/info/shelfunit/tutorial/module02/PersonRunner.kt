package info.shelfunit.tutorial.module02


fun doSomeStuff(): Unit {
    println("Hello World from doSomeStuff!")
    var kevin = Person()
    kevin.fName = "Kevin"
    println( "Name is ${kevin.fName}" )
    kevin.fName = "Steve"
    println( "Name is now ${kevin.fName}" )

    var joe = SecondPerson( "Joe" )
    println( "Name of SecondPerson joe is ${joe.fName}" )
    joe.display()
    println( "calling lambda function" )
    joe.displayWithLambda { printNameFromRunner( "CC" ) }
    // calling with function reference
    println( "Calling with reference" )
    joe.displayWithLambda( ::printNameFromRunner )
}
fun printNameFromRunner(name: String) {
    println( "in printNameFromRunner: " + name )
}

// class PersonRunner {

    fun main(args: Array<String>) {
        println( "args: " + args )
        println("Hello World!")
        doSomeStuff()
    }
// }
