/**
 * Markov model
 *
 * This function takes in a target word and a word list and returns an
 * associative array where the keys are the words that follow the target word
 * and the values are how many instances of those words occur
 *
 * @param targetWord a String representing the word to search for
 * @param wordList a list of Strings where every string is a word in the text
 *
 * @return the associative array generated based on the input word
 */

fun markov(targetWord: String, wordList: List<String>): AssociativeArray<String, Int> {
    val map = AssociativeArray<String, Int>()

    // Iterate through every word in wordList
    for (i in wordList.indices) {

        // If the current word matches the target word, add that word as a key in the array
        if (wordList[i] == targetWord) {
            val next = wordList[i + 1]
            val value = map[next]
            // If the value is null, this is a new key
            if (value == null) {
                map[next] = 1
            }
            else {
                map[next] = value + 1
            }
        }
    }

    return map
}