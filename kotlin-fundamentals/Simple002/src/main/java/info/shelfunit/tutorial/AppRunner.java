package info.shelfunit.tutorial;

import info.shelfunit.tutorial.DisplayFunctions;
import info.shelfunit.tutorial.module04.Module04Runner;
import info.shelfunit.tutorial.module04.Module04RunnerKt;

public class AppRunner {
    public static void main( String[] args ) {
        DisplayFunctions.newDisplay( "Hello from java" );
        Module04Runner m04Run = new Module04Runner();
        m04Run.logInClass( "Hello from java w/a level", 3 );
        m04Run.logInClass( "Hello from java w/default level" );
    }
}
