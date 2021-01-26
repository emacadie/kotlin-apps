package info.shelfunit.tutorial.module10

class Module10Runner {
}

fun main( args : Array< String > ) {
    println( "Hello from Module10Runner" )
    var user = User( "Kevin" )
    var count = 0
    var eventListner = { u:User -> println( "User $u has been created ${ ++count } times" ) }
    // SAM constructor
    var eventListner2 = Created( { println( "User $it has been created ${ ++count } times" ) } )
    user.create{ println( "User $it has been created ${ ++count } times" ) }
    user.create{ println( "User $it has been created ${ ++count } times" ) }
    user.create( eventListner )
    user.create( eventListner2 )
} // fun main