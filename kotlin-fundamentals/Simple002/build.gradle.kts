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
    // mainClassName = "cli.app.AppKt"
    // mainClass.set( "info.shelfunit.tutorial.AppRunner" )
    // mainClass.set( "info.shelfunit.tutorial.module02.PersonRunnerKt" )
    // mainClass.set( "info.shelfunit.tutorial.module03.Module03RunnerKt" )
    // mainClass.set( "info.shelfunit.tutorial.module04.Module04RunnerKt" )
    // mainClass.set( "info.shelfunit.tutorial.module05.Module05RunnerKt" )
    // mainClass.set( "info.shelfunit.tutorial.module06.Module06RunnerKt" )
    // Program has a main function in a companion object
    // its main fun is annotated w/@JvmStatic and must be called as "Program" NOT "ProgramKt"
    // mainClass.set( "info.shelfunit.tutorial.module06.Program" )
    // mainClass.set( "info.shelfunit.tutorial.module07.Module07RunnerKt" )
    // mainClass.set( "info.shelfunit.tutorial.module08.Module08RunnerKt" )
    // mainClass.set( "info.shelfunit.tutorial.module09.Module09RunnerKt" )
    // mainClass.set( "info.shelfunit.tutorial.module10.Module10RunnerKt" )
    // mainClass.set( "info.shelfunit.tutorial.module11.Module11RunnerKt" )
    // has null pointer exception
    // mainClass.set( "info.shelfunit.tutorial.module11.Organizer" )
    // mainClass.set( "info.shelfunit.tutorial.module12.Module12RunnerKt" )
    // mainClass.set( "info.shelfunit.tutorial.module13.Module13RunnerKt" )

    if ( project.hasProperty( "mainArgs" ) ) {
        println( "We have mainArgs" )
        println( project.findProperty( "mainArgs" ) )
        // project.set
    }
    if ( project.hasProperty( "ekmMain" ) ) {
        println( "We have ekmMain" )
        // println( project.findProperty( "mainArgs" ) )
        mainClass.set( project.findProperty( "ekmMain" ).toString() )
        // project.set
    }
    if ( project.hasProperty( "mainClass" ) ) {
        println( "We have mainClass" )
        // println( project.findProperty( "mainArgs" ) )
        mainClass.set( project.findProperty( "mainClass" ).toString() )
        // project.set
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


