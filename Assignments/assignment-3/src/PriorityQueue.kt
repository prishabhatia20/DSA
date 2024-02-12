import org.example.MinHeap

/**
 * ``MinPriorityQueue`` maintains a priority queue where the lower
 *  the priority value, the sooner the element will be removed from
 *  the queue.
 *  @param T the representation of the items in the queue
 */
interface MinPriorityQueue<T> {
    /**
     * @return true if the queue is empty, false otherwise
     */
    fun isEmpty(): Boolean

    /**
     * Add [elem] with at level [priority]
     */
    fun addWithPriority(elem: T, priority: Double)

    /**
     * Get the next (lowest priority) element.
     * @return the next element in terms of priority.  If empty, return null.
     */
    fun next(): T?

    /**
     * Adjust the priority of the given element
     * @param elem whose priority should change
     * @param newPriority the priority to use for the element
     *   the lower the priority the earlier the element int
     *   the order.
     */
    fun adjustPriority(elem: T, newPriority: Double)
}

/**
 * PriorityQueue inherits from the MinPriorityQueue interface.
 *
 * Contains methods to add to the heap, change element
 * priorities in the heap, check if the heap is empty,
 * and return the next element in the heap.
 *
 * @param T the representation of the items in the queue
 */
class PriorityQueue<T>: MinPriorityQueue<T> {

    private var heap = MinHeap<T>()


    /**
     * Method that returns whether the heap is empty or not
     *
     * @return a Boolean stating whether the heap is empty
     */
    override fun isEmpty(): Boolean {
        return heap.isEmpty()
    }

    /**
     * Get the next element (highest priority, lowest number)
     *
     * @return the element with the highest priority. If empty, return null
     */
    override fun next(): T? {
        return heap.getMin()
    }

    /**
     * Adjust the priority of the given element
     *
     * @param elem The element whose priority should change
     * @param newPriority the updated priority to use for that element
     */
    override fun adjustPriority(elem: T, newPriority: Double) {
        heap.adjustHeapNumber(elem, newPriority)
    }

    /**
     * Add an element with a specified priority
     *
     * @param elem the element being added
     * @param priority the priority with which to add the element
     */
    override fun addWithPriority(elem: T, priority: Double) {
        heap.insert(elem, priority)
    }

}


