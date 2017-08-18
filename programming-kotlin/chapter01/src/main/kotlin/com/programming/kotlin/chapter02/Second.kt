package com.programming.kotlin.chapter02

import mu.*

private val logger = KotlinLogging.logger {}

fun main( args: Array< String > ) {
    logger.info { "Hello world" }
    println( "Hello World!" )

}