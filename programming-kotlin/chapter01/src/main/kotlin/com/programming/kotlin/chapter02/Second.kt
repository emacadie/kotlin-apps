package com.programming.kotlin.chapter02

import mu.KotlinLogging
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*
import java.util.GregorianCalendar
import java.util.Calendar



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
    val rawStringB = """This is a second raw String. Can it do interpolation?
        Hello there
        here is what we insert: ${insertString}
        Wasn't that fun?
        """
    logger.info{ rawStringB }
    val name = "Sam"
    val str2 = "hello $name. Your name has ${name.length} characters"
    logger.info{ "Here is str2 with interpolation: ${str2}" }
}

fun useArrays(): Unit {
    val arrayA = arrayOf( 1, 2, 3 )
    logger.info{ "Here is arrayA: ${arrayA}" }
    println( arrayA )
    // val perfectSquares = Array(10, { k -> k * k })
    val element1 = arrayA[ 0 ]
    val element2 = arrayA[ 1 ]
    arrayA[ 2 ] = 5
    logger.info{ "Here is element1: ${element1}" }
    logger.info{ "Here is element2: ${element2}" }
    logger.info{ "We will get more into collections in chapter 10" }
}

fun useRanges(): Unit {
    val aToZ = "a".."z"
    val isTrue = "c" in aToZ
    val oneToNine = 1..9
    val isFalse = 11 in oneToNine

    val countingDown = 100.downTo(0)
    val rangeTo = 10.rangeTo(20)
    val oneToFifty = 1..50
    val oddNumbers = oneToFifty.step(2)
    logger.info{ "We will get into loops in a bit. So many ways to range!" }
    logger.info{ "A range cannot decrease. To do that, create a range and then reverse it" }
    // val countingDownEvenNumbers = (2..100).step(2).reversed()
}

fun StringBuilder.clear(): Unit {
    this.delete( 0, this.length ) // use "this" when adding functions, not "delegate" like in Groovy
    logger.info{ "Calling StringBuilder.clear" }
}


fun useLoops(): Unit {
    var count = 0
    var loopString = StringBuilder()
    while( count <= 3 ) {
        loopString.append("count in while is ${count}; " )
        count++
    }
    logger.info{ "Loop string: ${loopString}" }
    // loopString.delete( 0, loopString.length )
    loopString.clear()
    val set = setOf(1, 2, 3, 4)
    for (k in set) {
        loopString.append( "In for k in set where k is ${k}; " )
    }
    logger.info{ "Loop string: ${loopString}" }
    // loopString.delete( 0, loopString.length )
    loopString.clear()
    for ( k in 0..3 ) {
        loopString.append( "In for k in shorter range where k is ${k}; " )
    }
    logger.info{ "Loop string: ${loopString}" }
}

fun tryEquality(): Unit {
    val date2 = BigDecimal( 100 )
    val date3 = BigDecimal( 100 )
    val sameRef = date2 === date3
    logger.info{ "three equal signs === are used for referential equality (are we looking at same object)" }
    logger.info{ "Are date2 and date3 the same object? If they were strings with same value in Java, yes" }
    logger.info{ "Checking our BigDecimal objects for referential equality: ${sameRef}" }
    logger.info{ "two equal signs == are used for structural equality (like two copies of a book)" }
    val structural = date2 == date3
    logger.info{ "Checking our BigDecimal objects for structural equality: ${structural}" }
}

fun whatNumber(x: Int) {
    when (x) {
        0 -> logger.info{ "x is zero" }
        1 -> logger.info{ "x is one " }
        else -> logger.info{ "x is ${x}" }
    }
}

fun useWhen(): Unit {
    logger.info{ "Calling whatNumber, which uses when with 0: ${whatNumber( 0 )}" }
    logger.info{ "Calling whatNumber, which uses when with 1: ${whatNumber( 1 )}" }
    logger.info{ "Calling whatNumber, which uses when with 2: ${whatNumber( 2 )}" }
    logger.info{ "So with args, when replaces switch, without args it replaces if/else" }
}

fun main( args: Array< String > ) {
    logger.info { "Hello world" }
    println( "Hello World!" )
    printSomething()
    useValsAndVars()
    useNumbers()
    useStrings()
    useArrays()
    useRanges()
    useLoops()
    tryEquality()

    val localDateTimeNow: LocalDateTime = LocalDateTime.now()
    val today = if (localDateTimeNow.year == 2016) true else false
    logger.info{ "localDateTimeNow is ${localDateTimeNow}" }
    logger.info{ "Let's use control flow as an expression: ${today}; today is a ${today.javaClass.name}" }

    useWhen()
    logger.info{ "Many of these functions/methods return kotlin.Unit, which is like void in Java" }
    logger.info{ "Also: kotlin.Any is the root of Kotlin, like java.lang.Object is the root of Java" }
    logger.info{ "Does this mean there are two class hierarchies in Kotlin?" }
}
