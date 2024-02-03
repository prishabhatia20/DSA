import org.junit.jupiter.api.Assertions.*

class StackTest {

    @org.junit.jupiter.api.Test
    fun push() {
        val stack = MyStack<String>()
        stack.push("hello")
        stack.push("world")
        assertEquals(stack.peek(), "world")
        stack.pop()
        assertEquals(stack.peek(), "hello")
    }

    @org.junit.jupiter.api.Test
    fun pop() {
        // Test that pop works for null
        val stack = MyStack<String>()
        assertEquals(stack.pop(), null)
        stack.push("hello")
        stack.push("world")
        stack.push("!")
        assertEquals(stack.pop(), "!")

    }

    @org.junit.jupiter.api.Test
    fun peak() {
        val stack = MyStack<Int>()
        assertEquals(stack.peek(), null)

        stack.push(1)
        stack.push(10)
        stack.push(8)
        assertEquals(stack.peek(), 8)
    }

    @org.junit.jupiter.api.Test
    fun isEmpty() {
        val stack = MyStack<String>()
        assertTrue(stack.isEmpty())
        stack.push("hello")
        assertFalse(stack.isEmpty())
        stack.pop()
        assertTrue(stack.isEmpty())
    }
}