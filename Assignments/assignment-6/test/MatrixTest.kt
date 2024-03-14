import org.junit.jupiter.api.Assertions.*


class MatrixTest {

    @org.junit.jupiter.api.Test
            /**
             * Assert that get_value returns the correct values
             */
    fun get_value() {

        val matrix = Matrix(2)
        matrix.set_value(0, 0, 0.0)
        matrix.set_value(0, 1, 1.0)
        matrix.set_value(1, 0, 2.0)
        matrix.set_value(1, 1, 3.0)

        assertEquals(matrix.get_value(0, 0), 0.0)
        assertEquals(matrix.get_value(0, 1), 1.0)
        assertEquals(matrix.get_value(1, 0), 2.0)
        assertEquals(matrix.get_value(1, 1), 3.0)
    }

    @org.junit.jupiter.api.Test
            /**
             * Assert that the values are being set correctly -- the index
             * is correct
             */
    fun set_value() {

        val matrix = Matrix(2)
        matrix.set_value(0, 0, 4.0)
        matrix.set_value(0, 1, 5.0)
        matrix.set_value(1, 0, 6.0)
        matrix.set_value(1, 1, 7.0)


        assertEquals(matrix.get_value(0, 0), 4.0)
        assertEquals(matrix.get_value(0, 1), 5.0)
        assertEquals(matrix.get_value(1, 0), 6.0)
        assertEquals(matrix.get_value(1, 1), 7.0)
    }

    @org.junit.jupiter.api.Test
            /**
             * Assert that the size of the matrix is accurate
             */
    fun get_size() {
        val matrix = Matrix(2)
        assertEquals(matrix.get_size(), 2)
        val matrix2 = Matrix(100)
        assertEquals(matrix2.get_size(), 100)

    }
}