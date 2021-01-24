package info.shelfunit.tutorial.module06

abstract class Person ( var firstName : String, var lastName : String ) {

    open fun getName() : String = "$firstName $lastName"

    abstract fun getAddress() : String
}

open class Student( firstName : String, lastName : String, _id : Int, var tutor : String = "" ) : Person( firstName, lastName ) {
    val id : Int

    init {
        id = _id
    }

    fun enroll( courseName : String ) {
        val Course = Courses.allCourses
                            .filter{ it.Title == courseName }
                            .firstOrNull()
    }

    override fun getName() : String {
        return ""
    }
    override fun getAddress(): String {
        return ""
    }

    companion object : XmlSerializer< Student > {
        fun createUndergrad( name : String ) : Undergraduate {
            return Undergraduate( name )
        }
        fun createPostgrad( name : String ) : Postgraduate {
            return Postgraduate( name )
        }

        override fun toXml(item: Student) {
            println( "<student>${item.firstName}</student>" )
        }
    }
}

class Undergraduate ( firstName : String ) : Student( firstName, " ", 1 ) {

}

class Postgraduate ( firstName : String ) : Student( firstName, " ", 1 ) {

}

interface XmlSerializer< T > {
    fun toXml( item : T )
}

class Program {
    companion object {
        @JvmStatic
        fun main( args : Array< String > ) {
            println( "Program has a main" )

        }
    }
}
