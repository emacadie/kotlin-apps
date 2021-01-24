package info.shelfunit.tutorial.module05

sealed class PersonEvent {
    class Awake  : PersonEvent( )
    class Asleep : PersonEvent( )
    class Eating( val food : String ) : PersonEvent( )
}

fun handlePersonEvent( event : PersonEvent ) {
    when ( event ) {
        is PersonEvent.Awake  -> println( "Awake" )
        is PersonEvent.Asleep -> println( "Asleep" )
        is PersonEvent.Eating -> println( "Food: " + event.food )
    }
}
