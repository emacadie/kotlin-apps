package info.shelfunit.tutorial.module05

interface Time {
    fun setTime( hours: Int, mins: Int = 0, secs: Int = 0 )
    // has default implementation, so YetiTime will not complain
    fun setTime( time : KevinTime ) = setTime( time.hours )
}