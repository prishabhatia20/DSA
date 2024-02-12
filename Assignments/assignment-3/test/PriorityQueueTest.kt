import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class PriorityQueueTest {

    @Test
            /**
             * Test whether a given queue is empty or not
             */
    fun isEmpty() {
        val queue = PriorityQueue<Int>()

        assertEquals(queue.isEmpty(), true)
        queue.addWithPriority(1, 1.0)
        assertEquals(queue.isEmpty(), false)

    }

    @Test
    /**
     * Test that the function returns the element with the highest
     * priority
     */
    operator fun next() {
        val queue = PriorityQueue<Int>()

        queue.addWithPriority(1, 1.0)
        queue.addWithPriority(0, 0.0)
        queue.addWithPriority(2, 2.9)

        assertEquals(queue.next(), 0)
    }

    @Test
            /**
             * Test that adjusting the priotity of a queue
             * actually adjusts the queue
             */
    fun adjustPriority() {
        val queue = PriorityQueue<Int>()

        queue.addWithPriority(1, 1.0)
        queue.addWithPriority(0, 0.0)
        queue.addWithPriority(2, 2.9)

        assertEquals(queue.next(), 0)
        queue.adjustPriority(0, 50.0)
        assertEquals(queue.next(), 1)
    }

    @Test
            /**
             * Make sure an element is added with priority accurately
             */
    fun addWithPriority() {

        val queue = PriorityQueue<Int>()

        queue.addWithPriority(9, 90.0)
        assertEquals(queue.next(), 9)
        queue.addWithPriority(1, 9.0)
        assertEquals(queue.next(), 1)
    }
}