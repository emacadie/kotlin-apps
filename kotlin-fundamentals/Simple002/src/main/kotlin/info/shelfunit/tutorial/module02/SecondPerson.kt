package info.shelfunit.tutorial.module02

// This has a constructor in the definition
// we do not need to put fName in the class
class SecondPerson ( var fName: String )  {
    fun display() {
        println( "Display: $fName"  )
    }
    // the parameter is a function that takes a String and returns Unit (null in Kotlin)
    fun displayWithLambda( func: (s: String) -> Unit ) {
        func( fName )
    }
}




