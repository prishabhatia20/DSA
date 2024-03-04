import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Smith_watermanKtTest {

    @Test
            /**
             * Test various indices from the scoring matrix
             * Source: https://en.wikipedia.org/wiki/Smith%E2%80%93Waterman_algorithm#Example
             */
    fun matrix() {
        val a = "GGTTGACTA"
        val b = "TGTTACGG"

        val m = matrix(a, b, 3, -2)
        val scored = m.first

        assertEquals(scored[0][0], 0.0)
        assertEquals(scored[7][6], 13.0)

    }

    @Test
            /**
             * Test that backtracing returns the correct string
             */
    fun backtrace() {
        val a = "ATG"
        val b = "ATG"

        val m = matrix(a, b, 3, -2)

        val final_matrix = m.first
        val map = m.second

        val smith = backtrace(final_matrix, map, 3, -2, a, b)
        assertEquals(smith, Pair("ATG", "ATG"))

        // Test a string that does not match

        val c = "GGTTGACTA"
        val d = "TGTTACGG"

        val x = matrix(c, d, 3, -2)
        val matrix_cd = x.first
        val map_cd = x.second
        val smith_mismatch = backtrace(matrix_cd, map_cd, 3, -2, c, d)
        assertEquals(smith_mismatch, Pair("GTTGAC", "GTT-AC"))
    }

    @Test
            /**
             * Test the algorithm output
             */
    fun smith_waterman() {
        // Test a perfectly matching string
        val a = "ATG"
        val b = "ATG"

        val smith = smith_waterman(a, b, 3, -2)
        assertEquals(smith, Pair("ATG", "ATG"))

        // Test a string that does not match

        val c = "GGTTGACTA"
        val d = "TGTTACGG"

        val smith_mismatch = smith_waterman(c, d, 3, -2)
        assertEquals(smith_mismatch, Pair("GTTGAC", "GTT-AC"))
    }
}