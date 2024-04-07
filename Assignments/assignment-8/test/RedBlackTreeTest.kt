import org.junit.jupiter.api.Assertions.*

class RedBlackTreeTest {

    @org.junit.jupiter.api.Test
            /**
             * Assert that nodes are successfully inserted into the tree
             */
    fun insert() {
        val tree = RedBlackTree()
        tree.insert(0)
        assertEquals(tree.lookup(0), true)

        tree.insert(10)
        assertEquals(tree.lookup(10), true)

    }

    @org.junit.jupiter.api.Test
            /**
             * Assert that the function can identify whether nodes are in the tree or not
             */
    fun lookup() {
        val tree = RedBlackTree()
        tree.insert(0)
        assertEquals(tree.lookup(0), true)

        assertEquals(tree.lookup(10), false)
        tree.insert(10)
        assertEquals(tree.lookup(10), true)
    }
}