package com.programming.kotlin.chapter03

import mu.KotlinLogging

private val logger = KotlinLogging.logger {}



fun useBookPerson(): Unit {
    logger.info{ "In useBookPerson" }
    logger.info{ "A data class holds data, its methods don't really do much" }
    logger.info{ "But it looks like you can have a validating constructor" }
    val bp = BookPerson("Joe", "Smith", 24 )
    logger.info { "Here is the object toString: " + bp.toString() }
}

fun tryToCreatePeopleWithBadFirstNames(): Unit {
    logger.info{ "In tryToCreatePeopleWithBadFirstNames" }
    try {
        val bp = BookPerson("", "", -24 )
        logger.info { "Here is the object toString: " + bp.toString() }

    } catch ( e: Exception ) {
        logger.info { "Exception: " + e.javaClass.name }
        logger.info { "Message: " + e.message }
    }
    logger.info{ "It looks like our validating constructor only catches the first invalid argument and ignores the rest" }
}


fun main( args: Array< String > ) {
    logger.info { "Hello world" }
    println( "Hello World!" )
    useBookPerson()
    tryToCreatePeopleWithBadFirstNames()
}