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
    fun set_value(row: Int, col: Int, value: Double?) {
        if (value != null) {
            this.matrix[row][col] = value
        }
    }


    /**
     * Return the size of the matrix
     */
    fun get_size(): Int {
        return matrix.size
    }
}