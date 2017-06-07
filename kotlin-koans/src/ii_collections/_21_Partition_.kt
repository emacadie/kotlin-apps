package ii_collections

fun example8() {
    val numbers = listOf(1, 3, -4, 2, -11)

    // The details (how multi-assignment works) will be explained later in the 'Conventions' task
    val (positive, negative) = numbers.partition { it > 0 }

    positive == listOf(1, 3, 2)
    negative == listOf(-4, -11)
}

fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set< Customer > {
    // Return customers who have more undelivered orders than delivered
    val ( moreDelivered, moreUndelivered ) =
        this.customers.partition {
            it.orders.filter { it.isDelivered }.size >= it.orders.filter { !it.isDelivered }.size
        }
    println( "moreDelivered is a ${moreDelivered.javaClass.name}" )
    // todoCollectionTask()
    // that's kind of ugly, but on the other hand
    // https://github.com/shivan42/kotlin-koans-solution/blob/master/src/ii_collections/_21_Partition_.kt
    // ain't too hot either (IMHO)
    // I guess it never occurred to me that your predicate can be a multi-line routine
    // In Clojure, you mostly see single-line anonymous functions
    return moreUndelivered.toSet()
}
