import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.21"
    application
}

group = "me.ericm"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://dl.bintray.com/kotlin/kotlin-eap")
}

dependencies {
    testImplementation(kotlin("test-junit"))
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.github.microutils:kotlin-logging:2.0.4")
    implementation("org.slf4j:slf4j-api:1.7.30")
    implementation("ch.qos.logback:logback-classic:1.3.0-alpha5")
    implementation("ch.qos.logback:logback-core:1.3.0-alpha5")

}

tasks.test {
    useJUnit()
}

tasks.withType< KotlinCompile >() {
    kotlinOptions.jvmTarget = "11"
}

tasks.run {
    if ( project.hasProperty( "mainArgs" ) ) {
        println( "We have main" )

    }
}

application {
    // we could set main class here:
    // mainClass.set( "info.shelfunit.tutorial.module02.PersonRunnerKt" )

    if ( project.hasProperty( "mainArgs" ) ) {
        println( "We have mainArgs" )
        println( project.findProperty( "mainArgs" ) )
    }

    // or pass it in on command line
    if ( project.hasProperty( "mainClass" ) ) {
        println( "We have mainClass" )
        mainClass.set( project.findProperty( "mainClass" ).toString() )
    }
    // we can pass it in on command line w/another name to reduce ambiguity
    if ( project.hasProperty( "ekmMain" ) ) {
        println( "We have ekmMain" )
        mainClass.set( project.findProperty( "ekmMain" ).toString() )
    }
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "11"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "11"
}


