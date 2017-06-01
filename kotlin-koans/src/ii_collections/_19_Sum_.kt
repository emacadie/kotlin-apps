package ii_collections

fun example6() {
    val sum = listOf(1, 5, 3).sum()
}

public inline fun <T> Iterable<T>.sumByDoubleEKM( noinline selector: (T) -> Double): Double {
    var sum: Double = 0.0
    for (element in this) {
        println( "Here is sum: $sum; here is element: $element. Here is selector: $selector" )
        sum += selector(element)
    }
    return sum
}

fun Customer.getTotalOrderPrice(): Double {
    // Return the sum of prices of all products that a customer has ordered.
    // Note: a customer may order the same product for several times.
    // this.orders.flatMap { it.products }

    println( "this.orders.flatMap { it.products } is a " + this.orders.flatMap { it.products }.javaClass.name )
    // println( "Methods of ArrayList: "  )
    for ( nextMethod in this.orders.flatMap { it.products }.javaClass.methods ) {
        // println( nextMethod.name )
    }
    println( "What I need to know for " + this.name + ": " +
            this.orders.flatMap( { it.products } ).sumByDouble { it.price } )
    println( "Using sumByDoubleEKM: " + this.orders.flatMap( { it.products } ).sumByDoubleEKM { it.price }  )

    // I admit, I had to get this from someone else.
    // so the sumByDouble function is "inline" on the Iterable interface
    // java.util.ArrayList implements Iterable, so it gets that new function too
    // so is it sort of like metaprogramming in Groovy?
    // it looks like Kotlin has added some functions to ArrayList
    // and "it.price" is the "selector" function
    // according to http://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/sum-by-double.html
    // but "it.price" does not look to me like a function
    // and the code in the source is a bit weird too: selector( element )
    // unless it.price is a "function" because it is the getter?
    // but it.price does not take anything as an argument
    // maybe I am getting too deep into this
    // also: the first "it" is a Product inside an Order
    // the second "it" is the Price inside a Product
    // I understand what it does, but I think if I was tasked with
    // writing it, I would not be able to come up with it
    return this.orders.flatMap( { it.products } ).sumByDouble { it.price }
    // todoCollectionTask()
}
