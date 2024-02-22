import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MinHeapTest {

    @Test
    fun insert() {

        // Test that when inserting an element it places it in the correct location
        val heap = MinHeap()
        heap.insert(4)
        heap.insert(3)
        assertEquals(heap.peek(), 3)
    }

    @Test
    fun getHeap() {

        // Test that the sorted list is returned

        val heap = MinHeap()
        heap.insert(3)
        heap.insert(4)
        heap.insert(2)
        heap.insert(1)

        val correctList = mutableListOf(1, 2, 3, 4)
        assertEquals(heap.getHeap(), correctList)
    }

    @Test
    fun delete() {

        // Test that the heap reorders itself after an element is deleted
        val heap = MinHeap()
        heap.insert(4)
        heap.insert(3)
        heap.insert(4)
        heap.insert(2)
        heap.insert(1)
        heap.delete(2)
        val correctList = mutableListOf(1, 3, 4, 4)
        assertEquals(heap.getHeap(), correctList)

    }

    @Test
    fun peek() {
        // Test that peek() returns the first, lowest value element

        val heap = MinHeap()
        heap.insert(4)
        assertEquals(heap.peek(), 4)
        heap.insert(3)
        assertEquals(heap.peek(), 3)
    }
}