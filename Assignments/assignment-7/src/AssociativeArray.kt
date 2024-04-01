import kotlin.math.absoluteValue

/**
 * Represents a mapping of keys to values.
 * @param K the type of the keys
 * @param V the type of the values
 */
class AssociativeArray<K, V> {
    // Initial capacity of the associative array
    private var capacity = 16

    // Number of elements stored in the array
    private var size = 0


    // Array of mutable lists where each list holds pairs of keys and values
    private var array = Array<MutableList<Pair<K, V>>>(capacity) { mutableListOf()}

    /**
     * Insert the mapping from the key, [k], to the value, [v].
     * If the key already maps to a value, replace the mapping.
     */
    operator fun set(k: K, v: V) {
        if (size >= capacity * 0.75) {
            resize()
        }
        val index = getIndex(k)
        val list = array[index]
        val pair = list.find { it.first == k }
        // If the value is null, this is a new key
        if (pair == null) {
            list.add(k to v)
            size++
        }
        // Else, remove the current pair and re-add it at the same index
        else {
            remove(k)
            array[index].add(k to v)
            size++
        }
    }

    /**
     * @return true if [k] is a key in the associative array
     */
    operator fun contains(k: K): Boolean {
        val index = getIndex(k)
        return array[index].any { it.first == k }    }

    /**
     * @return the value associated with the key [k] or null if it doesn't exist
     */
    operator fun get(k: K): V? {
        val index = getIndex(k)
        return array[index].find { it.first == k }?.second
    }

    /**
     * Remove the key, [k], from the associative array
     * @param k the key to remove
     * @return true if the item was successfully removed and false if the element was not found
     */
    fun remove(k: K): Boolean {
        val index = getIndex(k)
        val list = array[index]
        val iterator = list.iterator()
        while (iterator.hasNext()) {
            val pair = iterator.next()
            if (pair.first == k) {
                iterator.remove()
                size--
                return true
            }
        }
        return false
    }


    /**
     * @return the number of elements stored in the hash table
     */
    fun size(): Int {
        return size
    }

    /**
     * @return the full list of key value pairs for the associative array or null if empty
     */
    fun keyValuePairs(): List<Pair<K, V>>? {
        if (size == 0) {
            return null
        }
        return array.flatMap { it }
    }

    /**
     * Given a key, return the index the key is placed at
     *
     * @return the index the key is held at
     */
    private fun getIndex(key: K): Int {
        val hashCode = key.hashCode()  // Get the hash code of the key
        val positiveHashCode = hashCode.absoluteValue  // Ensure the hash code is non-negative
        val index = positiveHashCode % capacity  // Calculate the index using modulus
        return index
    }

    /**
     * If the capacity reaches a certain threshold, resize the array to double
     * the current size
     */
    private fun resize() {
        capacity *= 2
        val temp = Array<MutableList<Pair<K, V>>>(capacity) { mutableListOf()}

        for (list in array) {
            for ((k, v) in list) {
                val index = getIndex(k)
                temp[index].add(k to v)

            }
        }
        array = temp
    }
}