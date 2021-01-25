package info.shelfunit.tutorial.module09

class Module09Runner {
}

class Meeting( val id : Int, val title : String ) {
    val people = listOf( Person( "Tom" ), Person( "James Madison" ) )
}

data class Person( val name : String ) {
    override fun toString() : String {
        return name
    }
}

fun iter( seq : Sequence< String > ) {
    println( "----------------------------" )
    println( "calling iter" )
    for ( t in seq ) println( "t in seq is: $t" )
}

fun main( args : Array< String > ) {
    println( "Hello from Module09Runner" )
    val meetings = listOf(
        Meeting( 1, "Board Meeting" ),
        Meeting( 2, "Committee Meeting" ),
        Meeting( 3, "City Council Meeting" ),
        Meeting( 4, "Meet with Reporter" ) )

    val filteredTitles = meetings
        .asSequence()
        .filter{ println( "filtering ${it.title}" ); it.title.endsWith( "g" ) }
        .map{ println( "mapping ${it.title}" ); it.title }
    println( "filteredTitles: " + filteredTitles )
    for ( ft in filteredTitles ) {
        print( "'$ft' " )
    }
    println( " " )

    println( "Working with uppercase to demonstrate terminal operations" )
    val ucTitles = meetings
        .asSequence()
        .map{ println( "Calling map on ${it.title}" ); it.title.toUpperCase() }
        .find{ it.startsWith( "B" ) }
    // using "asSequence" stops the instant "find" gets what it wants
    println( "ucTitles: $ucTitles" )

    val iterTitles = meetings
        .asSequence()
        .filter{ println( "filtering ${it.title}" ); it.title.endsWith( "g" ) }
        .map{ println( "mapping ${it.title}" ); it.title }
    iter( iterTitles )
} // end main
