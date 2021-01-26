package info.shelfunit.tutorial.module12

class Module12Runner {
}

class HomeAddress : JAddress {
    override fun getFirstAddress(): String {
        return ""
    }

}

class WorkAddress : JAddress {
    override fun getFirstAddress(): String? {
        return ""
    }

}

fun main( args : Array< String > ) {
    println( "Hello from Module12Runner" )
    val m = JMeeting()
    val title : String? = m.meetingTitle() // this throws an exception w/out annotation in Java
    println( "Here is the title: $title" )
    // can we add title?
    // m.addTitle( null ) // impossible if method has "@NotNull" annotation
    m.addTitle( "LL" )
    val title2 : String? = m.meetingTitle() // this throws an exception w/out annotation in Java
    println( "Here is the title: $title2" )

    val m2 = JMeeting()
    // val title3 : String = m2.titleCanBeNull()
    /*
    Run that, we get:
    Exception in thread "main" java.lang.NullPointerException: m2.titleCanBeNull() must not be null
        at info.shelfunit.tutorial.module12.Module12RunnerKt.main(Module12Runner.kt:20)
     */
    // so we can use our Kotlin tricks:
    val title3 : String = m2.titleCanBeNull() ?: "nobody"
    println( "title3 is $title3" )
} // end main
