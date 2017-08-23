package com.programming.kotlin.chapter02

import mu.*

private val logger = KotlinLogging.logger {}

fun printSomething(): Unit {
    logger.info( "in print something" )
    println( "in print something" )
}

fun useValsAndVars(): Unit {
    val theVal = "theval"
    var theVar = "thevar"
    logger.info{ "here is theVar: ${theVar}" }
    theVar = "still the var, baby"
    logger.info{ "theVar with new value: ${theVar}" }
    logger.info{ "here is theVal: " + theVal }
    logger.info{ "Trying to reassign a val will prevent compiliation. Viva Immutability" }
}

fun useNumbers(): Unit {
    logger.info{ "In useNumbers" }
    val intA         = 123
    val longA        = 123456L
    val doubleA      = 12.34
    val floatA       = 12.34F
    val hexadecimalA = 0xAB
    val binaryA      = 0b01010101
    logger.info{ "Here is intA: ${intA}" }
    logger.info{ "Here is longA: ${longA} (the \"L\" at the end is not printed)" }
    logger.info{ "Here is doubleA: ${doubleA}" }
    logger.info{ "Here is floatA: ${floatA} (the \"F\" at the end is not printed)" }
    logger.info{ "Here is hexadecimalA: ${hexadecimalA}" }
    logger.info{ "Here is binaryA: ${binaryA}" }
    logger.info{ "The int to log: ${intA.toLong()}" }

    val leftShift  = 1 shl 2
    val rightShift = 1 shr 2
    val unsignedRightShift = 1 ushr 2
    val andA = 1 and 0x00001111
    val orA  = 1 or 0x00001111
    val xorA = 1 xor 0x00001111
    val invA = 1.inv()
    logger.info{ "Here is leftShift: ${leftShift}" }
    logger.info{ "Here is rightShift: ${rightShift}" }
    logger.info{ "Here is unsignedRightShift: ${unsignedRightShift}" }
    logger.info{ "Here is andA: ${andA}" }
    logger.info{ "Here is orA: ${orA}" }
    logger.info{ "Here is xorA: ${xorA}" }
    logger.info{ "Here is invA: ${invA}" }
}

fun useStrings(): Unit {
    val stringA = "string with \n new line"
    val rawString = """
raw string is super useful for strings
that span many lines """
    logger.info{ "Here is stringA: ${stringA}" }
    logger.info{ "Here is rawString: ${rawString}" }
    val insertString = "This will be inserted"
    val rawStringB = """THis is a second raw String. Can it do interpolation?
        Hello there
        here is what we insert: ${insertString}
        Wasn't that fun?
        """
    logger.info{ rawStringB }
}

fun useArrays(): Unit {
    
}

fun main( args: Array< String > ) {
    logger.info { "Hello world" }
    println( "Hello World!" )
    printSomething()
    useValsAndVars()
    useNumbers()
    useStrings()
}
