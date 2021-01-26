package info.shelfunit.tutorial.module11

class Module11Runner {
}

class KMeeting {
    val canClose : Boolean = false
    lateinit var address : Address
    fun close() : Boolean {
        return true
    }
    fun save( o : Any ) {
        // check for null
        val saveable = o as? ISaveable
        saveable?.save()
    }

    fun init( addr : Address ) {
        address = addr
    }
} // class KMeeting

// We need to add "?" and "== true" to allow nullable and non-nullable meeting
fun closeMeeting( m : KMeeting? ) : Boolean {
    return if ( m?.canClose == true) {
        m?.close()
    } else {
        false
    }
}
// could also do this
fun closeMeeting2 ( m : KMeeting? ) : Boolean {
    return if ( m!!.canClose ) {
        m.close()
    } else {
        false
    }
}

fun closeMeetingNonNull ( m : KMeeting ) : Boolean {
    return if ( m.canClose ) {
        m.close()
    } else {
        false
    }
}

interface ISaveable {
    fun save()
}

class Address {

}

fun main( args : Array< String > ) {
    println( "Hello from Module11Runner" )
    var m : KMeeting? = null // m can be null
    var n = KMeeting()
    // n = m // type mismatch
    n = m ?: KMeeting()
    // n = m? // also won't work
    closeMeeting( n )
    closeMeeting( m ) // type mismatch error

    // closeMeetingNonNull
    m?.let { closeMeetingNonNull( m ) }
} // fun main