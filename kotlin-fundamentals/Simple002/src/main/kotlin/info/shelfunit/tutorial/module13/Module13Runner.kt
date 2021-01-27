package info.shelfunit.tutorial.module13

class Module13Runner {
}

class Person( val age : Int ) : Organizer {
    // when we override, we have to decide if the list and/or its members can be null
    override fun processMeetings( meetings: MutableList< Meeting >? ) {
        TODO("Not yet implemented")
    }

}

fun creatingCollections() {
    println( "In creatingCollections" )
    var people : List< Person? >? = null
    people = listOf( Person( 22 ), Person( 23 ), null )
    for ( person in people ) {
        println( "Age of person is: ${ person?.age }" )
    }

    var peopleM : MutableList< Person? >? = null
    peopleM = mutableListOf( Person( 22 ), Person( 23 ), null )
    peopleM.add( Person( 33 ) )
    for ( person in peopleM ) {
        println( "Age of person in mutable list is: ${ person?.age }" )
    }
    println( "looping through again w/filterNotNull" )
    for ( person in peopleM.filterNotNull() ) {
        println( "Age of person in mutable list w/filterNotNull is: ${ person?.age }" )
    }
} // creatingCollections

fun main( args : Array< String > ) {
    println( "Hello from Module13Runner" )
    // creatingCollections()
    for ( i in args.indices ) {
        println( "Here is arg: $i ${ args[ i ] }" )
    }
    val items = IntArray( 3 )
    items[ 0 ] = 3
    items[ 1 ] = 44
    items[ 2 ] = 55
    val numbers = intArrayOf( 1, 2, 3, 4, 5 )
    numbers.forEachIndexed { index, i ->
        println( "numbers: $index is $i" )
    }
} // main
