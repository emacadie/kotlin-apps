package ii_collections

fun example9() {
    val result = listOf(1, 2, 3, 4).fold(1, {
        partResult, element ->
        println( "in example9, here is element: " + element + ", here is partResult: " + partResult )
        element * partResult
    })
    result == 24
}

// The same as
fun whatFoldDoes(): Int {
    var result = 1
    listOf(1, 2, 3, 4).forEach { element -> result = element * result}
    return result
}

fun Shop.getSetOfProductsOrderedByEveryCustomer(): Set<Product> {
    // Return the set of products ordered by every customer
    println( "Here is allOrderedProducts: " + allOrderedProducts )
    println( "Here is example9: " + example9() )
    println( "Here is whatFoldDoes: " + whatFoldDoes() )

    return customers.fold(allOrderedProducts, {
        orderedByAll, customer ->
        println( "customer: " + customer.name )
        println( "Their products: " + customer.orderedProducts )
        orderedByAll.intersect( customer.orderedProducts )
    })
}
