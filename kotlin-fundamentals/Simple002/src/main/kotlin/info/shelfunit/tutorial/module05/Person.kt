package info.shelfunit.tutorial.module05

/* Orig code:
abstract class Person {
    var firstName : String = ""
    var lastName  : String = ""

    open fun getName() : String = "$firstName $lastName"

    abstract fun getAddress() : String
}

class Student( val id : Int ) : Person() {
    override fun getName() : String {
        return ""
    }
    override fun getAddress(): String {
        return ""
    }
}
*/

abstract class Person ( var firstName : String, var lastName : String ) {

    open fun getName() : String = "$firstName $lastName"

    abstract fun getAddress() : String
}

class Student( firstName : String, lastName : String, val id : Int ) : Person( firstName, lastName ) {
    var tutor : String

    init {
        tutor = "" // need this here since it is in secondary constructor, and not primary
    }
    // second constructor w/additional parameter
    constructor( firstName: String, lastName: String, id: Int, tutor : String ) : this( firstName, lastName, id ) {
        println( "In secondary constructor for Student" )
        this.tutor = tutor
    }

    override fun getName() : String {
        return ""
    }
    override fun getAddress(): String {
        return ""
    }
}

