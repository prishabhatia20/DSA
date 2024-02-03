import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MyQueueTest {

    @Test
    fun enqueue() {
        val queue = MyQueue<String>()

        queue.enqueue("Hello")
        queue.enqueue("World")

        assertEquals(queue.peek(), "Hello")
    }

    @Test
    fun dequeue() {
        val queue = MyQueue<String>()

        queue.enqueue("Hello")
        queue.enqueue("World")

        assertEquals(queue.dequeue(), "Hello")
    }

    @Test
    fun peek() {
        val queue = MyQueue<Int>()

        queue.enqueue(1)
        queue.enqueue(2)

        queue.dequeue()

        queue.enqueue(1)
        queue.enqueue(2)

        assertEquals(queue.peek(), 2)
    }

    @Test
    fun isEmpty() {

        val queue = MyQueue<Int>()

        queue.enqueue(1)
        queue.enqueue(2)

        queue.dequeue()

        queue.enqueue(1)
        queue.enqueue(2)

        assertEquals(queue.isEmpty(), false)

    }
}