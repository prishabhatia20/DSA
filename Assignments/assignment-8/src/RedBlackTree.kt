import java.util.*


/**
 * Class to create the red-black tree structure -- contains methods to fix
 * and maintain the 4 rules of the red black tree
 */
class RedBlackTree {
    // Create a node object
    private val NIL: Node = Node(99999).apply {
        color = BLACK
        left = null
        right = null
    }
    var root: Node = NIL

    /**
     * Helper function to perform a left-rotate operation on a given node
     *
     * @param x a Node object representing the node to rotate around
     */
    private fun leftRotate(x: Node) {
        val y = x.right
        x.right = y!!.left
        if (y.left != NIL) {
            y.left!!.p = x
        }
        y.p = x.p
        if (x.p == null) {
            root = y
        } else if (x == x.p!!.left) {
            x.p!!.left = y
        } else {
            x.p!!.right = y
        }
        y.left = x
        x.p = y
    }

    /**
     * Helper function to perform a right-rotate operation on a given node
     *
     * @param x a Node object representing the node to rotate around
     */
    private fun rightRotate(x: Node) {
        val y = x.left
        x.left = y!!.right
        if (y.right != NIL) {
            y.right!!.p = x
        }
        y.p = x.p
        if (x.p == null) {
            root = y
        } else if (x == x.p!!.right) {
            x.p!!.right = y
        } else {
            x.p!!.left = y
        }
        y.right = x
        x.p = y
    }

    /**
     * Function to insert a key into the red-black tree
     *
     * @param key an Integer representing the value of the node
     */
    fun insert(key: Int) {
        var z = Node(key)
        z.left = NIL
        z.right = NIL
        var y: Node? = null
        var x = root
        while (x != NIL) {
            y = x
            if (z.key < x.key) {
                x = x.left!!
            } else {
                x = x.right!!
            }
        }
        z.p = y
        if (y == null) {
            root = z
        } else if (z.key < y.key) {
            y.left = z
        } else {
            y.right = z
        }
        insertFixup(z)
    }

    /**
     * A helper function to insert a node while maintaining all the rules of the red-black tree
     * structure. This function checks for all invariants and fixes them
     *
     * @param z the node that is being inserted
     */
    private fun insertFixup(z: Node) {
        var z = z
        while (z.p != null && z.p!!.color == RED) {

            // Checking invariants
            if (z.p == z.p!!.p!!.left) {
                val y = z.p!!.p!!.right
                if (y!!.color == RED) {
                    z.p!!.color = BLACK
                    y.color = BLACK
                    z.p!!.p!!.color = RED
                    z = z.p!!.p!!
                } else {
                    if (z == z.p!!.right) {
                        z = z.p!!
                        leftRotate(z)
                    }
                    z.p!!.color = BLACK
                    z.p!!.p!!.color = RED
                    rightRotate(z.p!!.p!!)
                }
            } else {
                val y = z.p!!.p!!.left
                if (y!!.color == RED) {
                    z.p!!.color = BLACK
                    y.color = BLACK
                    z.p!!.p!!.color = RED
                    z = z.p!!.p!!
                } else {
                    if (z == z.p!!.left) {
                        z = z.p!!
                        rightRotate(z)
                    }
                    z.p!!.color = BLACK
                    z.p!!.p!!.color = RED
                    leftRotate(z.p!!.p!!)
                }
            }
            if (z == root) {
                break
            }
        }
        root.color = BLACK
    }

    /**
     * A function to print the tree out
     *
     * @param printColor a Boolean defaulting to false representing whether to print
     * the color associated with each node or not
     */
    fun printTree(printColor: Boolean = false) {
        val queue = ArrayDeque<Node?>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()

            if (printColor) {
                println("${node?.key}${node?.printColor()}")
            } else {
                println(node?.key)
            }

            // don't add NIL nodes
            if (node?.left != NIL) {
                queue.add(node?.left)
            }
            if (node?.right != NIL) {
                queue.add(node?.right)
            }
        }
    }

    /**
     * A function to lookup the exact value in a tree
     *
     * @param key an Integer that is the key being searched for
     * @return a Boolean representing whether that key is in the tree or not
     */
    fun lookup(key: Int): Boolean {
        return lookupRecursive(root, key)
    }


    /**
     * A recursive helper function that searches various subtrees for a given key
     *
     * @param node a Node object
     * @param key an Integer representing the key being searched for
     * @return a Boolean representing whether the key is in the tree
     */
    private fun lookupRecursive(node: Node?, key: Int): Boolean {
        if (node == null || node == NIL) {
            return false
        }

        if (key == node.key) {
            return true
        } else if (key < node.key) {
            return lookupRecursive(node.left, key)
        } else {
            return lookupRecursive(node.right, key)
        }
    }
}

