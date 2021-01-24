package info.shelfunit.tutorial.module05

class YetiTime : Time, EndOfTheWorld {

    override fun setTime( hours : Int, mins : Int, secs : Int ) {

    }

    override fun setTime( time: KevinTime ) {
        super< Time >.setTime( time )
        super< EndOfTheWorld >.setTime( time )
    }
}