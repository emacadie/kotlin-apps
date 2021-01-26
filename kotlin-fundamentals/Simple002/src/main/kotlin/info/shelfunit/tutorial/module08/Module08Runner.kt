package info.shelfunit.tutorial.module08

class Module08Runner {
}

fun filterAndMapInts() {
    println( "In filterAndMapInts" )
    val ints = listOf( 1, 2, 3, 4, 5 )
    // if predicate is true, member of source is added to target
    // again we use "it" keyword
    val smallInts = ints.filter { it < 4 }
    println( "ints: $ints" )
    println( "smallInts: $smallInts" )
    // maps transforms the data into something else
    val squaredInts = ints.map { it * it }
    println( "squaredInts: $squaredInts" )

    // lets combine them
    val smallSquaredInts = ints
        .filter{ it < 4 }
        .map{ it * it }
    println( "smallSquaredInts: $smallSquaredInts" )
} // filterAndMapInts

fun filterAndMapMeetings() {
    println( "in filterAndMapMeetings" )
    val meetings = listOf(
        Meeting( 1, "Board Meeting" ),
        Meeting( 2, "Committee Meeting" ),
        Meeting( 3, "City Council Meeting" ),
        Meeting( 4, "Meet with Reporter" ) )
    // incoming type different than outgoing type
    val titles = meetings.map{ m -> m.title }
    println( "titles: $titles" )
    // usually you want to filter first
    val filteredTitles = meetings
        .filter{ it -> it.title.startsWith( "C" ) }
        .map{ it -> it.title }
    println( "filteredTitles: " + filteredTitles )

    val reverseFilteredTitles = meetings
        .map{ it -> it.title }
        .filter{ it -> it.startsWith( "C" ) }
    // same result, we had to change the filter a bit
    println( "reverseFilteredTitles: " + reverseFilteredTitles )
} // filterAndMapMeetings

fun workWithPredicates() {
    println( "In workWithPredicates" )
    val ints = listOf( 1, 2, 3, 4, 5 )
    println( "ints: $ints" )
    // we can re-use predicate?
    val greaterThanThree = { v : Int -> v > 3 }
    // instead of "it > 3" over and over again
    // as lambda: val largeInts3 = ints.all{ it > 3 }
    // as variable, use parens instead of braces val largeInts3 = ints.all( greaterThanThree )
    // https://practicaltypography.com/parentheses-brackets-and-braces.html
    val largeInts6 = ints.all{ it > 6 }
    println( "largeInts6 comparing to 6: $largeInts6" )
    val largeInts3 = ints.all( greaterThanThree )
    println( "largeInts6 comparing to 3: $largeInts3" )
    val anyIntsLargerThan3 = ints.any( greaterThanThree )
    println( "anyIntsLargerThan3: $anyIntsLargerThan3" )
    var numberOfLargeInts = ints.count ( greaterThanThree )
    println( "numberOfLargeInts: $numberOfLargeInts" )
    // "find" returns first element. Is there a findAll
    var found = ints.find( greaterThanThree )
    println( "found: $found" )
    var found2 = ints.find { it > 6 } // returns null
    println( "found2: $found2" )
} // workWithPredicates

fun workWithMapAndFlatMap() {
    println( "In workWithMapAndFlatMap" )
    // get people in the meeting
    val meetings = listOf(
        Meeting( 1, "Board Meeting" ),
        Meeting( 2, "Committee Meeting" ),
        Meeting( 3, "City Council Meeting" ),
        Meeting( 4, "Meet with Reporter" ) )

    // returns a list of lists
    val people =  meetings.map{ it -> it.people } //  Meeting::people or it -> it.people
    println( "people: ${people.toString()}" )
    // return a flat list of names
    val flatPeople = meetings.flatMap{ it -> it.people }
    for ( p in flatPeople ) {
        print( "${  p.name } " )
    }
    println( " " )
    // but we have dups
    // use distinct, but that relies on hashCode() and equals, so we need to make Person a data class
    val distinctFlatMap = meetings.flatMap{ it -> it.people }.distinct()
    println( "distinctFlatMap: $distinctFlatMap" )
} // workWithMapAndFlatMap

class Meeting( val id : Int, val title : String ) {
    val people = listOf( Person( "Tom" ), Person( "James Madison" ) )
}

data class Person( val name : String ) {
    override fun toString() : String {
        return name
    }
}

fun main( args : Array< String > ) {
    println( "Hello from Module08Runner" )
    // filterAndMapInts()
    // filterAndMapMeetings()
    // workWithPredicates()
    // workWithMapAndFlatMap()
} // fun main

