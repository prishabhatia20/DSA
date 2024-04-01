import org.junit.jupiter.api.Assertions.*

class AssociativeArrayTest {

    @org.junit.jupiter.api.Test
            /**
             * Assert that setting key-value pairs works
             */
    fun set() {
        val map = AssociativeArray<Int, String>()
        map[1] = "one"
        assertEquals(map[1], "one")

        map[2] = "two"
        assertEquals(map[2], "two")

        map[-1] = "-one"
        assertEquals(map[-1], "-one")
    }

    @org.junit.jupiter.api.Test
            /**
             * Test that the contains function accurately identifies where an element
             * is in the array
             */
    fun contains() {
        val map = AssociativeArray<Int, String>()
        map[1] = "one"
        assertEquals(map.contains(1), true)

        map[2] = "two"
        assertEquals(map.contains(2), true)

        assertEquals(map.contains(3), false)
    }

    @org.junit.jupiter.api.Test
            /**
             * Test that the value associated with a key is accurately returned
             */
    fun get() {
        val map = AssociativeArray<Int, String>()
        map[1] = "one"
        assertEquals(map[1], "one")

        map[2] = "two"
        assertEquals(map[2], "two")

        map[-1] = "-one"
        assertEquals(map[-1], "-one")
    }

    @org.junit.jupiter.api.Test
            /**
             * Test that elements of the array can be removed
             */
    fun remove() {
        val map = AssociativeArray<Int, String>()
        map[1] = "one"
        assertEquals(map.contains(1), true)

        map[2] = "two"
        assertEquals(map.contains(2), true)

        map.remove(1)
        assertEquals(map.contains(1), false)
        map.remove(2)
        assertEquals(map.contains(2), false)
    }

    @org.junit.jupiter.api.Test
            /**
             * Test that the function returns the number of elements in the array
             */
    fun size() {
        val map = AssociativeArray<Int, String>()
        assertEquals(map.size(), 0)
        map[1] = "one"
        assertEquals(map.size(), 1)
        map[1] = "ONE!"
        assertEquals(map.size(), 1)
        map.remove(1)
        assertEquals(map.size(), 0)
    }

    @org.junit.jupiter.api.Test
            /**
             * Assert that the function returns all key-value pairs in the array
             */
    fun keyValuePairs() {
        val map = AssociativeArray<Int, String>()
        assertEquals(map.keyValuePairs(), null)
        map[1] = "one"
        assertEquals(map.keyValuePairs(), listOf(Pair(1, "one")))
        map[2] = "two"
        assertEquals(map.keyValuePairs(), listOf(Pair(1, "one"), Pair(2, "two")))

        map.remove(1)
        assertEquals(map.keyValuePairs(), listOf(Pair(2, "two")))
        map[2] = "TWO!"
        assertEquals(map.keyValuePairs(), listOf(Pair(2, "TWO!")))
    }
}