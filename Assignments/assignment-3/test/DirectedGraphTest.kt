import junit.framework.TestCase.assertEquals
import org.junit.jupiter.api.Assertions.*

class DirectedGraphTest {

    @org.junit.jupiter.api.Test
            /**
             * Test that getVertices returns a list of vertices
             */
    fun getVertices() {
        val graph = DirectedGraph<Int>()

        // Using the first weighted graph here: https://hyperskill.org/learn/step/5645
        graph.addEdge(0, 1, 3.0)
        graph.addEdge(0, 3, 7.0)
        graph.addEdge(0, 4, 8.0)
        graph.addEdge(1, 2, 1.0)
        graph.addEdge(1, 3, 4.0)
        graph.addEdge(3, 2, 2.0)
        graph.addEdge(4, 3, 3.0)

        assertEquals(graph.getVertices().sorted(), mutableListOf(0, 1, 2, 3, 4))
    }

    /**
     * Assert that clearing a graph results in an empty list
     */
    @org.junit.jupiter.api.Test
    fun clear() {
        val graph = DirectedGraph<Int>()

        graph.addEdge(0, 1, 3.0)
        graph.addEdge(0, 3, 7.0)
        graph.addEdge(0, 4, 8.0)
        graph.addEdge(1, 2, 1.0)
        graph.addEdge(1, 3, 4.0)
        graph.addEdge(3, 2, 2.0)
        graph.addEdge(4, 3, 3.0)

        graph.clear()

        assertEquals(graph.getVertices(), mutableListOf<Int>())
    }

    /**
     * Assert that all edges from a given vertex are returned
     */
    @org.junit.jupiter.api.Test
    fun getEdges() {
        val graph = DirectedGraph<Int>()

        graph.addEdge(0, 1, 3.0)
        graph.addEdge(0, 3, 7.0)
        graph.addEdge(0, 4, 8.0)
        graph.addEdge(1, 2, 1.0)
        graph.addEdge(1, 3, 4.0)
        graph.addEdge(3, 2, 2.0)
        graph.addEdge(4, 3, 3.0)

        // Proper syntax???
        assertEquals(graph.getEdges(0), mutableMapOf(1 to 3, 3 to 7, 4 to 8))
    }

    /**
     * Assert that an edge between two vertices can successfully be added
     */
    @org.junit.jupiter.api.Test
    fun addEdge() {
        val graph = DirectedGraph<Int>()

        graph.addEdge(0, 1, 3.0)

        assertEquals(graph.getEdges(0), mutableMapOf(1 to 3))
    }
}