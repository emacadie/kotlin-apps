package ii_collections

import ii_collections.data.customers
import ii_collections.data.lucas
import ii_collections.data.nathan
import org.junit.Assert.assertEquals
import org.junit.Test

class _19_Sum {
    @Test fun testGetTotalOrderPrice() {
        // TODO: what do the double exclamation marks mean?
        assertEquals(148.0, customers[nathan]!!.getTotalOrderPrice(), 0.001)
    }

    @Test fun testTotalPriceForRepeatedProducts() {
        assertEquals(586.0, customers[lucas]!!.getTotalOrderPrice(), 0.001)
    }
}
