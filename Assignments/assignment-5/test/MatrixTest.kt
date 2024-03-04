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

    @org.junit.jupiter.api.Test

            /**
             * Test that the traditional matrix multiplication works
             */
    fun multiply() {
        val matrix1 = Matrix(4)
        for (i in 0..3) {
            for (j in 0..3) {
                matrix1.set_value(i, j, 1.0)
            }
        }

        val matrix2 = Matrix(4)
        for (i in 0..3) {
            for (j in 0..3) {
                matrix2.set_value(i, j, 1.0)
            }
        }

        var correct = Matrix(4)
        correct = matrix1.multiply(matrix2)!!

        assertEquals(correct.get_value(0, 0), 4.0)
    }

    @org.junit.jupiter.api.Test
            /**
             * Assert that Strassen multiplication works properly
             */
    fun strassenMultiply() {
        val matrix1 = Matrix(4)
        for (i in 0..3) {
            for (j in 0..3) {
                matrix1.set_value(i, j, 1.0)
            }
        }

        val matrix2 = Matrix(4)
        for (i in 0..3) {
            for (j in 0..3) {
                matrix2.set_value(i, j, 1.0)
            }
        }

        var correct = Matrix(4)
        correct = matrix1.strassenMultiply(matrix2)!!

        assertEquals(correct.get_value(0, 0), 4.0)
    }

    @org.junit.jupiter.api.Test
            /**
             * Assert that matrices get combined correctly -- a, b, c, d results in [a b: c d]
             */
    fun combine() {
        val a = Matrix(2)
        val b = Matrix(2)
        val c = Matrix(2)
        val d = Matrix(2)

        a.set_value(0, 0, 0.0)
        a.set_value(0, 1, 1.0)
        a.set_value(1, 0, 2.0)
        a.set_value(1, 1, 3.0)

        b.set_value(0, 0, 4.0)
        b.set_value(0, 1, 5.0)
        b.set_value(1, 0, 6.0)
        b.set_value(1, 1, 7.0)

        c.set_value(0, 0, 8.0)
        c.set_value(0, 1, 9.0)
        c.set_value(1, 0, 10.0)
        c.set_value(1, 1, 11.0)

        d.set_value(0, 0, 12.0)
        d.set_value(0, 1, 13.0)
        d.set_value(1, 0, 14.0)
        d.set_value(1, 1, 15.0)

        var combined = Matrix(4)
        combined = a.combine(a, b, c, d)
        assertEquals(combined.get_value(0, 0), a.get_value(0, 0))



    }

    @org.junit.jupiter.api.Test
            /**
             * Test that the matrix splits into the four quadrants accurately
             */
    fun split() {
        // Matrix:
        // [1 2 5 6]
        // |3 4 7 8|
        // |9 10 13 14|
        // [11 12 15 16]

        val matrix = Matrix(4)
        val list1 = mutableListOf(1.0, 2.0, 5.0, 6.0)
        val list2 = mutableListOf(3.0, 4.0, 7.0, 8.0)
        val list3 = mutableListOf(9.0, 10.0, 13.0, 14.0)
        val list4 = mutableListOf(11.0, 12.0, 15.0, 16.0)

        for (i in 0..3) {
            for (j in 0..3) {
                if (i == 0) {
                    matrix.set_value(i, j, list1[j])
                }
                else if (i == 1) {
                    matrix.set_value(i, j, list2[j])
                }
                else if (i == 2) {
                    matrix.set_value(i, j, list3[j])
                }
                else {
                    matrix.set_value(i, j, list4[j])
                }
            }
        }

        val (topHalf, bottomHalf) = matrix.split()
        val a = topHalf.first
        val b = topHalf.second
        val c = bottomHalf.first
        val d = bottomHalf.second

        // Test that the matrices are the size they should be
        assertEquals(a.get_size(), 2)
        assertEquals(b.get_size(), 2)
        assertEquals(c.get_size(), 2)
        assertEquals(d.get_size(), 2)


        // Test that the correct quadrant has been identified
        assertEquals(a.get_value(0, 0), 1.0)
        assertEquals(a.get_value(0, 1), 2.0)
        assertEquals(a.get_value(1, 0), 3.0)
        assertEquals(a.get_value(1, 1), 4.0)
    }

    @org.junit.jupiter.api.Test
    fun addMatrix() {
        val matrix1 = Matrix(2)
        val matrix2 = Matrix(2)

        // [1 1: 13 2]
        matrix1.set_value(0, 0, 1.0)
        matrix1.set_value(1, 1, 2.0)
        matrix1.set_value(1, 0, 13.0)
        matrix1.set_value(0, 1, 1.0)
        // [1 1: 13 2]
        matrix2.set_value(0, 0, 1.0)
        matrix2.set_value(1, 1, 2.0)
        matrix2.set_value(1, 0, 13.0)
        matrix2.set_value(0, 1, 1.0)

        // [2 2: 26 4]
        val sum = matrix1.addMatrix(matrix2)

        assertEquals(sum.get_value(0, 0),2.0)
        assertEquals(sum.get_value(0, 1),2.0)
        assertEquals(sum.get_value(1, 0),26.0)
        assertEquals(sum.get_value(1, 1),4.0)




    }

    @org.junit.jupiter.api.Test
    fun subtractMatrix() {
        val matrix1 = Matrix(2)
        val matrix2 = Matrix(2)

        // [5 1: 14 2]
        matrix1.set_value(0, 0, 5.0)
        matrix1.set_value(1, 1, 2.0)
        matrix1.set_value(1, 0, 14.0)
        matrix1.set_value(0, 1, 20.0)
        // [1 1: 13 2]
        matrix2.set_value(0, 0, 1.0)
        matrix2.set_value(1, 1, 2.0)
        matrix2.set_value(1, 0, 13.0)
        matrix2.set_value(0, 1, 1.0)

        // [4 0: 1 19]
        val difference = matrix1.subtractMatrix(matrix2)


    }
}