class Matrix(size: Int) {

    val matrix = Array(size) { DoubleArray(size) }

    /**
     * Return the value at a specific index
     * @param [row] the row the value is in
     * @param [col] the column the value is in
     *
     * @return the value at the specified index
     */
    fun get_value(row: Int, col: Int): Double {
        return this.matrix[row][col]
    }

    /**
     * Set the value at a specified row & column
     *
     * @param [row] the row to set the value in
     * @param [col] the column to set the value in
     * @parem [value] the value the user wants to set
     */
    fun set_value(row: Int, col: Int, value: Double) {
        this.matrix[row][col] = value
    }


    /**
     * Return the size of the matrix
     */
    fun get_size(): Int {
        return matrix.size
    }

    /**
     * Multiply [this] matrix by [other].
     * You can implement this either using block-based matrix multiplication or
     * traditional matrix multiplication (the kind you learn about in math
     * classes!)
     * @return [this]*[other] if the dimensions are compatible and null otherwise
     */
    fun multiply(other: Matrix): Matrix? {
        // Make sure that the size of [other] equals the size of the current matrix

        val matrix_size = get_size()
        
        if (other.get_size() != matrix_size) {
            return null
        }
        val result = Matrix(matrix_size)

        for (i in 0..< matrix_size) {
            for (j in 0..< matrix_size) {
                result.set_value(i, j, 0.0)

                var result_val = 0.0
                for (k in 0..< matrix_size) {
                    result_val += this.get_value(i, k) * other.get_value(k, j)

                }
                result.set_value(i, j, result_val)
            }
        }

        return result

    }

    /**
     * Multiply [this] matrix by [other].
     * Your code should use Strassen's algorithm
     * @return [this]*[other] if the dimensions are compatible and null otherwise
     */
    fun strassenMultiply(other: Matrix): Matrix? {
        // Make sure that the size of [other] equals the size of the current matrix
        val matrix_size = get_size()

        if (other.get_size() != matrix_size) {
            return null
        }
        if (matrix_size < 1024) {
            return this.multiply(other)
        }

        var result = Matrix(matrix_size)


        // Base case
        if (matrix_size == 1) {
            result.set_value(0, 0, (this.get_value(0, 0) * other.get_value(0, 0)))
            return result
        }

        // Split this.matrix into four matrices
        val (topHalf, bottomHalf) = this.split()
        val a = topHalf.first
        val b = topHalf.second
        val c = bottomHalf.first
        val d = bottomHalf.second

        // Split other.matrix into four matrices
        val (top, bottom) = other.split()
        val e = top.first
        val f = top.second
        val g = bottom.first
        val h = bottom.second


        // Recursive call
        val p1 = a.strassenMultiply(f.subtractMatrix(h))!!
        val p2 = a.addMatrix(b).strassenMultiply(h)!!
        val p3 = c.addMatrix(d).strassenMultiply(e)!!
        val p4 = d.strassenMultiply(g.subtractMatrix(e))!!
        val p5 = a.addMatrix(d).strassenMultiply(e.addMatrix(h))!!
        val p6 = b.subtractMatrix(d).strassenMultiply(g.addMatrix(h))!!
        val p7 = a.subtractMatrix(c).strassenMultiply(e.addMatrix(f))!!

        // Add quadrants
        val c11 = (p5.addMatrix(p4)).subtractMatrix(p2).addMatrix(p6)
        val c12 = p1.addMatrix(p2)
        val c21 = p3.addMatrix(p4)
        val c22 = p1.addMatrix(p5).subtractMatrix(p3).subtractMatrix(p7)

        // Combine quadrants into matrix
        result = combine(c11, c12, c21, c22)

        return result


    }


    /**
     * Combine four matrices into one big matrix
     *
     * @param [a] the matrix (type Matrix) that goes in the upper-left
     * quadrant
     *
     * @param[b] the matrix (type Matrix) that goes in the upper-right
     * quadrant
     *
     * @param[c] the matrix (type Matrix) that goes in the bottom-left
     * quadrant
     *
     * @param[d] the matrix (type Matrix) that goes in the bottom-right
     * quadrant
     *
     * @return a Matrix that is all four matrices combined
     */
    fun combine(a: Matrix, b: Matrix, c: Matrix, d: Matrix): Matrix {

        val a_size = a.get_size()
        val matrix_size = 2 * a_size
        val combined = Matrix(matrix_size)
        // [a b : c d]
        for (i in 0..< matrix_size / 2) {

            for (j in 0..< matrix_size/ 2) {
                combined.set_value(i,j, a.get_value(i,j))
                combined.set_value(i,j+a_size, b.get_value(i,j))
                combined.set_value(i+a_size,j, c.get_value(i,j))
                combined.set_value(i+a_size,j+a_size, d.get_value(i,j))
            }
        }

        return combined
    }


    /**
     * Split one matrix into four smaller matrices
     *
     * @return a pair of pairs -- the first pair holds the matrices
     * in the top half, and the second pair holds the matrices
     * in the bottom half
     */
    fun split(): Pair<Pair<Matrix, Matrix>, Pair<Matrix, Matrix>> {
        val row_size = this.get_size()
        val col_size = matrix[0].size

        val row2 = row_size / 2
        val col2 = col_size / 2

        val a = Matrix(row2)
        val b = Matrix(row2)
        val c = Matrix(row2)
        val d = Matrix(row2)

        // Matrix a from [0: row2] [0: col2]

        for (row in 0..< row2) {
            for (col in 0..< col2) {
                a.set_value(row, col, this.get_value(row, col))
            }
        }

        // Matrix b from [0: row2] [col2: end]
        for (row in 0..< row2) {
            for (col in col2..< col_size) {
                b.set_value(row, col-col2, this.get_value(row, col))
            }
        }

        // Matrix c from [row2: end] [0: col2]
        for (row in row2..< row_size) {
            for (col in 0..< col2) {
                c.set_value(row - row2, col, this.get_value(row, col))
            }
        }

        // Matrix d from [row2: end] [col2: end]
        for (row in row2..< row_size) {
            for (col in col2..< col_size) {
                d.set_value(row - row2, col - col2, this.get_value(row, col))
            }
        }


        // return four new matrices
        return Pair(Pair(a, b), Pair(c, d))
    }


    /**
     * Add two matrices ([this] and [other]
     *
     * @param [other] the matrix to add to [this] -- type Matrix
     *
     * @return a Matrix that is the sum of [this] and [other]
     */
    fun addMatrix(other: Matrix): Matrix {
        val size = other.get_size()

        val result = Matrix(size)

        for (i in 0..< size) {
            for (j in 0..< size) {
                result.set_value(i, j, (this.get_value(i, j) + other.get_value(i, j)))
            }
        }

        return result

    }

    /**
     * Subtract two matrices ([this] and [other]
     *
     * @param [other] the matrix to subtract from [this] -- type Matrix
     *
     * @return a Matrix that is the difference of [this] and [other]
     */
    fun subtractMatrix(other: Matrix): Matrix {
        val size = other.get_size()

        val result = Matrix(size)

        for (i in 0..< size) {
            for (j in 0..< size) {
                result.set_value(i, j, (this.get_value(i, j) - other.get_value(i, j)))
            }
        }
        return result
    }

}