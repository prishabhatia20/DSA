import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class BubbleSortKtTest {
    @Test
    fun test1() {
        // Test that the function sorts the list with all different elements
        var list = mutableListOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
        var correctList = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        assertEquals(bubbleSort(list), correctList)


        // Test that the function sorts a list with some elements being similar
        list = mutableListOf(1, 2, 2, 3, 5, 0, 2, 3, 5)
        correctList = mutableListOf(0, 1, 2, 2, 2, 3, 3, 5, 5)
        assertEquals(bubbleSort(list), correctList)

        // Test that it returns the already sorted list
        list = mutableListOf(1, 2, 3, 4, 5)
        correctList = mutableListOf(1, 2, 3, 4, 5)
        assertEquals(bubbleSort(list), correctList)
    }
}
