package info.shelfunit.tutorial.module06



class Module06Runner {
}

fun main( args : Array< String > ) {
    println( "Hello from Module06Runner" )
    println( "Hello again from Module06Runner" )

    Student.createUndergrad( "Simon" ) // calling method on Student class, not an instance
    Student.createPostgrad( "Doctor" )
}

