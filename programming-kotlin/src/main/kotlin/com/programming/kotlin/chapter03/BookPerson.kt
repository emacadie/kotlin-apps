package com.programming.kotlin.chapter03

data class BookPerson ( val firstName: String, val lastName: String, val age: Int? ) {
    init {
        require( firstName.trim().length > 0 ) {
            "Invalid firstName argument." + firstName }
        require( lastName.trim().length > 0 ) {
            "Invalid lastName argument."
        }
        if ( age != null ) {
            require(age >= 0 && age < 150 ) { "Invalid age argument." + age }
        }
    }

    override fun toString(): String {
        return "firstName: " + this.firstName + ", lastName: " + this.lastName +
                ", age: " + this.age

    }

}
