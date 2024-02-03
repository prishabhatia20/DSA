class DoublyLinkedList<T> {

    // Pointer that points to the first node in the list
    var head: ListNode<T>? = null
    var tail: ListNode<T>? = null

    /**
     * Add the element [data] to the front of the linked list
     */
    fun pushFront(data: T) {
        val newNode = ListNode<T>(data, head, null)
        if (tail == null) {
            tail = newNode
        }
        head?.prev = newNode
        head = newNode

    }

    /**
     * Add the element [data] to the end of the linked list
     */
    fun pushBack(data: T) {
        val newNode = ListNode<T>(data, null, tail)
        if (head == null) {
            head = newNode
        }
        tail?.next = newNode
        tail = newNode

    }

    /**
     * Remove the element at the front of the list. If the list is empty, it is unchanged
     *
     * @return the value at the front of the list or null if the list is empty
     */
    fun popFront(): T? {
        val temp = head?.data
        head = head?.next
        if (head == null) {
            tail = null
        }
        head?.prev = null

        return temp

    }

    /**
     * Remove the element at the back of the list. If the list is empty, it is unchanged
     *
     * @return the value at the back of the list or null if the list is empty
     */
    fun popBack(): T? {

        val temp = tail?.data
        tail = tail?.prev

        if (tail == null) {
            head = null
        }
        tail?.next = null

        return temp

    }

    /**
     * @return the value at the front of the list, or null if the list is empty
     */
    fun peekFront(): T? {
        return head?.data

    }

    /**
     * @return the value at the back of the list, or null if the list is empty
     */
    fun peekBack(): T? {
        return tail?.data

    }

    /**
     * @return a Boolean indicating whether the list is empty or not
     */
    fun isEmpty(): Boolean {
        return (head == null)
    }
}

/**
 * A class that creates a new node every time it is called
 *
 * @param data Data of type T
 * @param next A variable pointing to the next node in the list, or null if it is the last
 * @param prev A variable pointing to the previous node in the list, or null if it is the first
 */
class ListNode<T>(val data: T, var next: ListNode<T>?, var prev: ListNode<T>?)
// Stores data, doesn't have any function
// Can just define attributes in parentheses