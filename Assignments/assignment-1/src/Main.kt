// Question 1: The features I like about Kotlin are the mutable versus read-only
// variable declarations. I feel like it's a lot safer than just naming a variable in
// all-caps because once I named a variable in all-caps for a project but my partner
// didn't know that all-caps meant the variable should not be changed so the code didn't
// work, and it took a while to debug.

// Question 2: I don't think there was anything I was expecting to find that I haven't. I
// didn't have any expectations going into learning about this language, so I feel like
// there was nothing I was expecting.

// Question 3: I don't currently have any questions, but I think as I start programming and
// getting into more advanced code I will.



class TicTacToeBoard() {

    /**
     * A class to play TicTacToe
     * board: a list of three lists that contain three empty strings
     * counter: an integer tracking which player's turn it is
     *
     */
    val board: MutableList<MutableList<String>>
    var counter: Int

    init {
        var first_row: MutableList<String> = mutableListOf(" ", " ", " ")
        var second_row: MutableList<String> = mutableListOf(" ", " ", " ")
        var third_row: MutableList<String> = mutableListOf(" ", " ", " ")

        board = mutableListOf(first_row, second_row, third_row)

        counter = 1

    }


    fun next_move(): String {

        /**
         * A method that checks whose turn it is and returns
         * the appropriate player
         *
         * Returns: A string representing which player is next ("X", "O")
         */

        if (counter % 2 == 1) {
            return "X"
        }

        return "O"
    }

    fun mark(row: Int, col: Int) {
        /**
         * A method that marks the square the player passes in if
         * it is empty
         *
         * Args:
         * row: an int representing a row on the board (0, 1, 2)
         * col: an int representing a column on the board (0, 1, 2)
         */
        if (board[row][col] != " ") {
            throw Exception("Value Error")
        }

        board[row][col] = next_move()
        counter++

    }

    fun get_square(row: Int, col: Int): String {
        /**
         * A method that returns what's on the square the player inputs
         *
         * Args:
         * row: an integer representing a row on the board
         * col: an integer representing a column on the board
         *
         * Returns: a String representing the mark in that space (" ", "X", or "O")
         */
        return board[row][col]
    }

    fun check_win(player: String): Boolean {
        /**
         * A method that checks whether a specific player has won.
         * This method checks horizontal, vertical, diagonal, and anti-diagonal wins
         *
         * Args:
         * player: A String representing which player to check for a win
         *
         * returns: A boolean representing whether they have won or not
         */

        // Check horizontal win
        for (row in 0..2) {
            var count = 0
            for (col in 0..2) {
                if (board[row][col] == player) {
                    count++
                }
            }
            if (count == 3) {
                return true
            }

        }

        // Check vertical win

        for (col in 0..2) {
            var count = 1
            for (row in 0..2) {
                if (board[row][col] == player) {
                    count++
                }
            }
            if (count == 3) {
                return true
            }
        }

        // Check diagonal win top left to bottom right
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true

        }

        // Check bottom left to top right diagonal

        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true
        }

        return false


    }


    override fun toString(): String {
        /**
         * toString method that prints out the board
         */
        // Row 1
        var first_row = "|"

        for (col in 0..2) {
            first_row += board[0][col] + "|"
        }

        // Row 2
        var second_row = "|"

        for (col in 0..2) {
            second_row += board[1][col] + "|"
        }

        // Row 3
        var third_row = "|"

        for (col in 0..2) {
            third_row += board[2][col] + "|"
        }

        return "+-+-+-+\n$first_row\n+-+-+-+\n$second_row\n+-+-+-+\n$third_row\n+-+-+-+"

    }
}

fun main() {
    val board = TicTacToeBoard()
    board.mark(0, 0)
    board.mark(1, 1)
    board.mark(2, 2)
    board.mark(0, 1)
    board.mark(2, 1)
    board.mark(1, 0)
    board.mark(2, 0)
    board.check_win("X")
    print(board)

}