// Define two constants
const val BLACK = true
const val RED = false

/**
 * Node class to create nodes
 *
 * @param key an integer holding the value represented by that node
 */
class Node(var key: Int) {
    // Parent node
    var p: Node? = null
    // Node color
    var color: Boolean = RED
    var left: Node? = null
    var right: Node? = null

    /**
     * A function to print the color of the node
     *
     * @return a String representing the color of the node
     */
    fun printColor(): String {
        return if (color == BLACK) {
            "(b)"
        } else {
            "(r)"
        }
    }
}