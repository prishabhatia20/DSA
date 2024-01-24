import org.junit.jupiter.api.Assertions.*

class TicTacToeBoardTest {

    @org.junit.jupiter.api.Test
    fun getCounter() {
        // Test whether the counter is correctly initialized
        val board = TicTacToeBoard()
        assert(board.counter == 1)

    }

    @org.junit.jupiter.api.Test
    fun next_move() {
        // Test whether next_move returns the proper player
        val board = TicTacToeBoard()
        board.mark(0, 0)
        board.mark(1, 1)
        board.mark(2, 2)
        board.mark(2, 0)
        assert(board.next_move() == "X")
    }

    @org.junit.jupiter.api.Test
    fun mark() {

        // Test whether the mark() function correctly increments
        // the counter
        val board = TicTacToeBoard()
        board.mark(0, 0)
        board.mark(1, 1)
        assert(board.counter == 3)

    }

    @org.junit.jupiter.api.Test
    fun check_win() {

        // Test whether the check_win function is accurate

        val board = TicTacToeBoard()

        board.mark(0, 0)
        board.mark(1, 1)
        board.mark(2, 2)
        board.mark(0, 1)
        board.mark(2, 1)
        board.mark(1, 0)
        board.mark(2, 0)
        assert(board.check_win("X"))

    }
}