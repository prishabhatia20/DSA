import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.io.File

class MarkovKtTest {

    @Test
    fun markov() {
        val file = File("/Users/pbhatia/IdeaProjects/assignment-7/src/Tell-Tale-Heart")
        val text = file.readText()
        // Tokenize the text into words
        val words = text.split("\\s+".toRegex())
        // Remove punctuation from words
        val cleanWords: List<String> = words.map { it.replace(Regex("[^A-Za-z0-9]"), "") }
            .filter { it.isNotBlank() }

        assertEquals(markov("kill", cleanWords).keyValuePairs(), listOf(Pair("the", 1), Pair("it", 1)))

        assertEquals(markov("little", cleanWords).keyValuePairs(), listOf(Pair("by", 1), Pair("I", 1), Pair("so", 1)))

    }
}