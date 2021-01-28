package info.shelfunit.tutorial.module14

class Module14Runner {
}

val action = { println( "This is action" ) }
val calc = { x : Int, y : Int -> x * y }
val cal2  : ( Int, Int ) -> Int = { x, y -> x * y }

fun doSomething( func: () -> Unit ) {
    println( "In doSomething()" )
    func()
}

inline fun < T > first( items : List< T >, predicate: ( T ) -> Boolean ) : T {
    for ( item in items ) {
        if ( predicate ( item ) ) return item
    }
    throw Exception()
}

fun main( args : Array< String > ) {
    println( "Hello from Module14Runner" )
    doSomething( action )
    println( "Calling calc( 3, 4 ): ${ calc( 3, 4 ) }" )
    val ints = listOf( 1, 2, 3, 4, 5 )
    // are predicates the same as functions?
    println( "Calling first( ints, { i -> i == 3 } ): ${ first( ints, { i -> i == 3 } ) } " )
    println( "Calling first( ints, { i -> i > 3 } ): ${ first( ints, { i -> i > 3 } ) } " )
} // main
