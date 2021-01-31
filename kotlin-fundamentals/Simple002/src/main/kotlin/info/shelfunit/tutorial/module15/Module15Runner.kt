package info.shelfunit.tutorial.module15

class Module15Runner {
}

// generic function
fun < T > List< T >.itemAt( indx : Int ) : T {
    return this[ indx ]
}

class Node< T > ( private val item : T ) {
    fun value() : T {
        return item
    }
}

// this cannot be a String
class NodeN< T : Number > ( private val item : T ) {
    fun value() : T {
        return item
    }
}

fun workWithGenerics() {
    var names = listOf( "George", "John", "Tom" )

    for ( x in 0..( names.size - 1 ) ) {
        println( "calling names.itemAt( $x ): ${ names.itemAt( x ) }" )
    }

    val n : NodeN< Int > = NodeN( 2 )
    println( "Here is n: ${ n.value() }" )
} // workWithGenerics

open class Meeting {
    fun attend() {
        println( "Meeting was attended" )
    }
}

class BoardMeeting : Meeting() {}

class FinanceMeeting : Meeting() {}

// we can filter a list of meetings into a list of a particular type of meeting
inline fun < reified T > List< * >.typeOf() : List< T > {
    val returnList = mutableListOf< T >()
    for ( item in this ) {
        if ( item is T ) {
            returnList.add( item )
        }
    }
    return returnList
}

fun < T : Meeting > buildMeeting( meetingClass : Class< T >, action: ( T ) -> Unit ) : T {
    val meeting : T = meetingClass.getDeclaredConstructor().newInstance()
    action( meeting )
    return meeting
}

// better function
inline fun < reified T : Meeting > buildMeeting( noinline action : ( T ) -> Unit ) : T {
    /*
    val meeting = T :: class.java.getDeclaredConstructor().newInstance()
    action( meeting )
    return meeting
    */
    // or.... mark "action" param as "noinline" and call other "buildMeeting"
    return buildMeeting( T :: class.java, action )

}

fun workMoreWithGenerics() {
    println( "In workMoreWithGenerics" )
    val meetings = mutableListOf( BoardMeeting(), FinanceMeeting() )
    val board = meetings.typeOf< BoardMeeting >(  )
    println( "Count of board meetings: ${ board.count() }" )
    meetings.add( BoardMeeting() )
    val board2 = meetings.typeOf< BoardMeeting >()
    println( "Count of board meetings after adding 1: ${ board2.count() }" )
} // workMoreWithGenerics

class AllMeetings< out T : Meeting > ( val meetings : List< Meeting > ) {
    val count : Int get() = meetings.count()
    operator fun get( i : Int ) = meetings[ i ]
}

fun attendAllMeetings( meetings : AllMeetings< Meeting > ) {
    for ( i in 0 until meetings.count ) {
        meetings[ i ].attend()
    }
}

fun main( args : Array< String > ) {
    println( "Hello from Module15Runner" )
    workWithGenerics()
    workMoreWithGenerics()

    var financeMeetings = mutableListOf( FinanceMeeting() )
    financeMeetings.add( FinanceMeeting() )
    var meetings : AllMeetings< FinanceMeeting > = AllMeetings( financeMeetings )
    // compiler doesn't like this; it wants Meeting, not FinanceMeeting; change AllMeetings param to "out T"
    attendAllMeetings( meetings )

} // main
