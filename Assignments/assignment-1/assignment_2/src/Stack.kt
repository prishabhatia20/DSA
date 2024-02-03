interface Stack<T> {

    fun push(data: T)

    fun pop(): T?

    fun peek(): T?

    fun isEmpty(): Boolean
}

/**
 * An implementation of a LIFO structure called Stack
 * @param T data stored in the stack
 */

class MyStack<T>: Stack<T> {

    private val list = DoublyLinkedList<T>()


    /**
     * Push [data] onto the Stack
     *
     * @param data The new value to put onto the stack
     */

    override fun push(data: T) {
        list.pushFront(data)
    }


    /**
     * Pop the top element off the stack
     *
     * @return the top element if the stack is not empty, else return null
     */

    override fun pop(): T? {
        return list.popFront()
    }


    /**
     * @return the top element if the stack is not empty, else return null
     */

    override fun peek(): T? {
        return list.peekFront()
    }

    /**
     * @return True if the stack is empty, else return False
     */

    override fun isEmpty(): Boolean {
        return list.isEmpty()
    }

}


