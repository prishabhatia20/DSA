import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class FloydWarshallKtTest {

    @Test
            /**
             * Test the returned matrix. This matrix should store the predecessor
             * vertex for a path from one vertex to another. For example, the
             * value of prev[i][j] would be predecessor of vertex j on the shortest
             * path from i to j
             * Example Graph: https://en.wikipedia.org/wiki/Floyd%E2%80%93Warshall_algorithm
             * Note: Nodes in the Wikipedia graph index from 1, my implementation indexes from 0
             */
    fun floydWarshall() {
        val graph1 = Matrix(4)

        val INFINITY = Int.MAX_VALUE

        val graph1_list:MutableList<Int> = mutableListOf(0, INFINITY, -2, INFINITY, 4, 0, 3, INFINITY, INFINITY, INFINITY, 0, 2, INFINITY, -1, INFINITY, 0)

        var count = 0
        for (i in 0..<graph1.get_size()) {
            for (j in 0..<graph1.get_size()) {
                val put = graph1_list[count]
                graph1.set_value(i, j, put.toDouble())
                count++
            }
        }

        val dist1 = Matrix(4)
        for (i in 0..< dist1.get_size()) {
            for (j in 0..< dist1.get_size()) {
                dist1.set_value(i, j, INFINITY.toDouble())
            }
        }

        val prev1 = Matrix(4)
        for (i in 0..< prev1.get_size()) {
            for (j in 0..< prev1.get_size()) {
                dist1.set_value(i, j, null)
            }
        }
        val output1 = floydWarshall(graph1, dist1, prev1)
        // Test that the predecessor from a path from a vertex to itself is the
        // vertex itself
        assertEquals(output1.get_value(0, 0), 0.0)

        // Test the predecessor value for a path between two vertices that are connected
        assertEquals(output1.get_value(0, 2), 0.0)

        // Test the predecessor value for a path between vertices that are not next to each other
        assertEquals(output1.get_value(0, 3), 2.0)

    }

    @Test
            /**
             * Test that the output path is the correct path
             *
             * Example Graph: https://en.wikipedia.org/wiki/Floyd%E2%80%93Warshall_algorithm
             * Note: Nodes in the Wikipedia graph index from 1, my implementation indexes from 0
             */
    fun backtrace() {

        val graph1 = Matrix(4)

        val INFINITY = Int.MAX_VALUE

        val graph1_list:MutableList<Int> = mutableListOf(0, INFINITY, -2, INFINITY, 4, 0, 3, INFINITY, INFINITY, INFINITY, 0, 2, INFINITY, -1, INFINITY, 0)

        var count = 0
        for (i in 0..<graph1.get_size()) {
            for (j in 0..<graph1.get_size()) {
                val put = graph1_list[count]
                graph1.set_value(i, j, put.toDouble())
                count++
            }
        }

        val dist1 = Matrix(4)
        for (i in 0..< dist1.get_size()) {
            for (j in 0..< dist1.get_size()) {
                dist1.set_value(i, j, INFINITY.toDouble())
            }
        }

        val prev1 = Matrix(4)
        for (i in 0..< prev1.get_size()) {
            for (j in 0..< prev1.get_size()) {
                dist1.set_value(i, j, null)
            }
        }
        val output1 = floydWarshall(graph1, dist1, prev1)

        // Test a path not between two nodes
        assertEquals(backtrace(output1, 0, 1), mutableListOf(0, 2, 3, 1))

        // Test a path directly between two nodes
        assertEquals(backtrace(output1, 0, 2), mutableListOf(0, 2))

        // Test the path from the vertex to the same vertex
        assertEquals(backtrace(output1, 0, 0), mutableListOf(0))

    }
}