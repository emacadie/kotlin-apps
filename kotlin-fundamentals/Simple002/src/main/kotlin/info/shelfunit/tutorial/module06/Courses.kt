package info.shelfunit.tutorial.module06

class Course( val Id : Int, val Title : String ) {

}

object Courses {
    var allCourses = arrayListOf< Course >()

    fun initialize() {
        allCourses.add( Course( 1, "Kotlin Fundamentals" ) )
        allCourses.add( Course( 2, "Object-oriented Programming with Go" ) )
        allCourses.add( Course( 3, "Getting Started with Elixir" ) )
    }
}