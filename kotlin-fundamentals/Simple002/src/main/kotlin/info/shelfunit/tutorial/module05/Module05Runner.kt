package info.shelfunit.tutorial.module05

class Module05Runner {


}

data class DataStudent( val id : Int, val name : String ) {

}

// main has to be in .kt file, but not in the class braces
fun main( args : Array< String > ) {
    val kevin = Student("Kevin", "Jones", 1 )
    println( "Id of ${kevin.firstName} ${kevin.lastName}: ${ kevin.id }" )
    val mikeV = Student( "Mike", "VanSickle", 2, "Ken Thompson" )
    println( "mikeV to string: " + mikeV.toString() )

    var kevin2 = DataStudent( 1, "Kevin" )
    var kevin3 = DataStudent( 1, "Kevin" )
    if ( kevin2 == kevin3 ) {
        println( "kevin2 and kevin3 are equal" )
    } else {
        println( "kevin2 and kevin3 are not equal" )
    }
    // narrator voice: If they are not data classes, they are not equal. Different references at first
    println( "Here is kevin2: ${ kevin2.toString() }" )
    val kevin4 = kevin2.copy( id = 3 )
    println( "kevin4 was copied from kevin2: ${ kevin4.toString() }" )
}
