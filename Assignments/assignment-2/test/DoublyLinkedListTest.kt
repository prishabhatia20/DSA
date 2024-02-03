import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class DoublyLinkedListTest {

    @Test
    fun pushFront() {
        val list = DoublyLinkedList<Int>()

        list.pushFront(1)
        list.pushFront(0)
        list.pushBack(10)
        list.pushFront(3)

        assertEquals(list.peekFront(), 3)
    }

    @Test
    fun pushBack() {
        val list = DoublyLinkedList<Int>()
        assertEquals(list.peekBack(), null)

        list.pushBack(3)
        list.pushBack(4)
        list.popBack()
        list.pushBack(5)
        assertEquals(list.peekBack(), 5)
    }

    @Test
    fun popFront() {
        val list = DoublyLinkedList<Int>()

        list.pushFront(1)
        list.pushFront(0)
        list.pushBack(40)
        assertEquals(list.popFront(), 0)
        assertEquals(list.popFront(), 1)
        assertEquals(list.popFront(), 40)
        assertEquals(list.popFront(), null)
    }

    @Test
    fun popBack() {
        val list = DoublyLinkedList<Int>()

        list.pushFront(1)
        list.pushFront(0)
        list.pushBack(40)
        assertEquals(list.popBack(), 40)
        assertEquals(list.popBack(), 1)
        assertEquals(list.popBack(), 0)
        assertEquals(list.popBack(), null)
    }

    @Test
    fun peekFront() {
        val list = DoublyLinkedList<Int>()

        list.pushFront(3)
        list.pushFront(2)
        list.pushFront(1)
        assertEquals(list.peekFront(), 1)
    }

    @Test
    fun peekBack() {
        val list = DoublyLinkedList<Int>()

        list.pushFront(3)
        list.pushFront(2)
        list.pushFront(1)
        assertEquals(list.peekBack(), 3)
    }

    @Test
    fun isEmpty() {

        val list = DoublyLinkedList<Int>()
        assertEquals(list.isEmpty(), true)
        list.pushFront(3)
        list.pushFront(2)
        assertEquals(list.isEmpty(), false)
    }
}