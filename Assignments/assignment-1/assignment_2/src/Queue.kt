interface Queue<T> {

    fun enqueue(data: T)

    fun dequeue(): T?

    fun peek(): T?

    fun isEmpty(): Boolean
}

/**
 * An implementation of a FIFO structure called Queue
 *
 * @param T data stored in the stack
 */
class MyQueue<T>: Queue<T> {
    val list = DoublyLinkedList<T>()

    /**
     * Add [data] to the end of the queue
     *
     * @param data The new value to put into the queue
     */
    override fun enqueue(data: T) {
        list.pushBack(data)
    }

    /**
     * Remove the element at the front of the queue.
     *
     * @return the value at the front of the queue or null if the queue is empty
     */
    override fun dequeue(): T? {
        return list.popFront()
    }

    /**
     * @return the value at the front of the queue or null if the queue is empty
     */
    override fun peek(): T? {
        return list.peekFront()
    }

    /**
     * @return a Boolean saying whether the queue is empty or not
     */
    override fun isEmpty(): Boolean {
        return list.isEmpty()
    }

}