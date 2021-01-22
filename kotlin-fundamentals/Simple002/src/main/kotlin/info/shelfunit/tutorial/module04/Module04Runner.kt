package info.shelfunit.tutorial.module04

import java.math.BigInteger

class Module04Runner {
    @JvmOverloads
    fun logInClass( message: String, logLevel: Int = 1 ) {
        println( "Here is message: $message and here is logLevel: $logLevel" )

    }
}

fun display() {
    println( "Hello from display!" )
}

fun newDisplay( message: String ) : Boolean {
    println( message )
    return true
}

fun max( a: Int, b:Int ): Int = if ( a > b ) a else b

fun log( message: String, logLevel: Int = 1 ) {
    println( "Here is message: $message and here is logLevel: $logLevel" )

}

fun workWithDefaultArgs() {
    log( "First message", 2 )
    log( "second message" )
    println( "Lets call log w/named params and change order" )
    print( "Calling named params in order: " )
    log( message = "This is the first param", logLevel = 10 )
    print( "Not calling optional param w/default value: " )
    log( message = "This is the message without a log level" )
    print( "Calling params out of order: " )
    log( logLevel = 4, message = "The log level came first" )
}

fun replaceMultipleWhitespace( value: String ) : String {
    var regex = Regex( "\\s+" )
    return regex.replace( value, " " )
}

fun String.replaceMultipleWhitespaceEx( ) : String {
    var regex = Regex( "\\s+" )
    return regex.replace( this, " " )
}

fun workWithExtensionFunctions() {
    val textForOurRegex = "With      multiple  \t whitespace"
    println( replaceMultipleWhitespace( textForOurRegex ) )
    // note: It did not work with iterpolation
    println( "Calling it as a helper on string: " + textForOurRegex.replaceMultipleWhitespaceEx() )
}

fun Header.firstPlus( other:Header ) : Header {
    return Header(this.Name + other.Name)
}

infix fun Header.plusAgain( other:Header ) : Header {
    return Header(this.Name + other.Name)
}

operator infix fun Header.plus( other: Header ) : Header {
    return Header( this.Name + other.Name )
}

fun workWithInfixFunctions() {
    val h1 = Header( "h1" )
    val h2 = Header( "h2" )
    val h3 = h1.firstPlus( h2 )
    println( "h3: ${ h3.Name }" )

    val h4 = h1 plusAgain h2
    println( "h4 created w/infix function: ${h4.Name}" )
    val h5 = h1 + h2
    println( "h5 created w/operator infix function: ${h5.Name}" )
}

tailrec fun fibonacci( n: Int, a: BigInteger, b: BigInteger ) : BigInteger {
    return if ( n == 0 ) b else fibonacci( ( n - 1 ), ( a + b ), a )
}

fun main( args: Array< String > ) {

    println( "Hello World! from Module04Runner" )
    display()
    var nD = newDisplay( "How are you?" )
    println( "nD is $nD"  )

    println( "Calling function expression max( 1, 2 ): " + max( 1, 2 ) )

    workWithDefaultArgs()
    workWithExtensionFunctions()
    workWithInfixFunctions()
    val fibNum = 10
    println( "Doing fibonacci up to $fibNum: " + fibonacci( fibNum, BigInteger( "1" ), BigInteger( "0" ) ) )

}