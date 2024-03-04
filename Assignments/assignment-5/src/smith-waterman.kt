import java.util.*

/**
 * Function that creates a matrix and scores it according to the gap cost and match score provided by the user
 *
 * @param[a] a String that is the first string to compare
 * @param[b] a String that is the second string to compare
 * @param [match_score] an integer that is the score to add if there is perfect alignment
 * @param[gap_cost] an integer that is the cost of no alignment
 *
 * @return a mutable map of two Pairs of integers. The first pair is an index in the matrix, and the second pair
 * is the index that it inherits from. This is used for backtracing
 */
fun matrix(a: String, b: String, match_score: Int, gap_cost: Int): Pair<Array<DoubleArray>, MutableMap<Pair<Int, Int>, Pair<Int, Int>>> {
    var prev: MutableMap<Pair<Int, Int>, Pair<Int, Int>> = mutableMapOf()
    val row = a.length + 1
    val col = b.length + 1

    // a is row, b is col
    val array = Array(row) { DoubleArray(col) }


    for (i in 1..< array.size) {
        for (j in 1..< array[0].size) {
            // Calculate matching, deletion, and insertion costs
            val match = array[i - 1][j - 1] + if (a[i - 1] == b[j - 1]) match_score else -match_score
            val delete = array[i - 1][j] + gap_cost
            val insert = array[i][j - 1] + gap_cost
            if (match > delete && match > insert && match > 0) {
                array[i][j] = match
                prev[Pair(i, j)] = Pair(i - 1, j - 1)
            } else if (delete > insert && delete > 0) {
                array[i][j] = delete
                prev[Pair(i, j)] = Pair(i - 1, j)
            } else if (insert > 0) {
                array[i][j] = insert
                prev[Pair(i, j)] = Pair(i, j - 1)
            } else {
                array[i][j] = 0.0
            }
        }
    }
    // Print out the matrix
    for (i in 1..<array.size) {
        for (j in 1..<array[0].size) {
            print("${array[i][j]}  ")
        }
        println()
    }
    return Pair(array, prev)

}

/**
 * A function that traces back through the entire matrix to return the aligned sequences
 *
 * @param[matrix] The filled in cost matrix
 * @param[map] A mutable map of pairs of ints, used for tracing back through the matrix
 * @param[match_score] an integer representing how much to add if there is a match
 * @param[gap_cost] an integer representing how much to subtract if there is not a match
 * @param[a] the first String to compare
 * @param[b] the second String to compare
 *
 * @return a Pair of Strings -- the first String is the matched string a, and the second String is the matched string b
 */
fun backtrace(matrix: Array<DoubleArray>, map: MutableMap<Pair<Int, Int>, Pair<Int, Int>>, match_score: Int, gap_cost: Int, a: String, b: String): Pair<String, String> {

    var max_elem = 0.0
    var i_val = 0
    var j_val = 0

    // Find the max element and its index in the matrix
    for (i in 0..< matrix.size) {
        for (j in 0..< matrix[0].size) {
            if (matrix[i][j] > max_elem) {
                max_elem = matrix[i][j]
                i_val = i
                j_val = j
            }
        }
    }



    var i = i_val
    var j = j_val
    var match_a = ""
    var match_b = ""

    var matrix_val = matrix[i][j]
    while (matrix_val > 0.0) {
        val prev_i = map[Pair(i, j)]?.first!!
        val prev_j = map[Pair(i, j)]?.second!!

        val prev_val = matrix[prev_i][prev_j]
        // If the difference is equal to the match score, both letters match
        if ((matrix_val - prev_val).toInt() == match_score) {
            match_a += a[i - 1]
            match_b += b[j - 1]
        }
        // If the difference is equal to the gap cost and i is one less, add a gap in b
        else if ((matrix_val - prev_val).toInt() == gap_cost && i - prev_i == 1) {
            match_a += a[i - 1]
            match_b += "-"
        }
        // If the difference is equal to the gap cost and j is one less, add a gap in a
        else {
            match_a += "-"
            match_b += b[j - 1]
        }

        // Update i, j, and matrix_val
        i = prev_i
        j = prev_j
        matrix_val = matrix[i][j]
    }

    // Reverse the strings
    val reversed_a = match_a.reversed()
    val reversed_b = match_b.reversed()

    return Pair(reversed_a, reversed_b)
}

/**
 * A sequence alignment algorithm that finds the most optimal alignment of two strings, including insertions and
 * deletions
 *
 * @param[a] one of the two Strings to match
 * @param[b] the second String to compare with string a
 * @param[match_score] an integer determining how much to add if there is alignment
 * @param[gap_cost] an integer determining how much to subtract if there is no alignment
 *
 * @return a pair of Strings, the first being the aligned string a and the second being the aligned string b
 */
fun smith_waterman(a: String, b: String, match_score: Int, gap_cost: Int): Pair<String, String> {
    val a_upper = a.uppercase()
    val b_upper = b.uppercase()

    val M = matrix(a_upper, b_upper, match_score, gap_cost)
    val table = M.first
    val map = M.second
    val traceback = backtrace(table, map, match_score, gap_cost, a, b)
    return traceback

}

