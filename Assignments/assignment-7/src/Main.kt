package org.example
import java.io.File
import AssociativeArray
import markov

fun main() {

    val file = File("/Users/pbhatia/IdeaProjects/assignment-7/src/Tell-Tale-Heart")
    val text = file.readText()
    // Tokenize the text into words
    val words = text.split("\\s+".toRegex())
    // Remove punctuation from words
    val cleanWords: List<String> = words.map { it.replace(Regex("[^A-Za-z0-9]"), "") }
        .filter { it.isNotBlank() }


    print(markov("kill", cleanWords).keyValuePairs())


    // Associative array testing
    val map = AssociativeArray<Int, String>()

    // Insertion
    map[1] = "One"
    map[2] = "Two"
    map[3] = "Three"
    map[4] = "Four"
    map[5] = "Five"
    map[6] = "Six"
    map[7] = "Seven"
    map[8] = "Eight"
    map[9] = "Nine"
    map[10] = "Ten"
    map[11] = "Eleven"
    map[12] = "Twelve"
    map[13] = "Thirteen"
    map[14] = "Fourteen"
    map[15] = "Fifteen"
    map[16] = "Sixteen"

    // Retrieval
    println("Value for key 1: ${map[1]}") // One
    println("Value for key 10: ${map[10]}") // Ten

    // Removal
    map.remove(5)
    println("Size after removal: ${map.size()}") // 15
    println("Key-Value pairs: ${map.keyValuePairs()}") // [(1, One), (2, Two), ..., (16, Sixteen)]

    // Contains
    println("Contains key 5: ${5 in map}") // false
    println("Contains key 15: ${15 in map}") // true

    // Key-Value pairs
    println("Key-Value pairs: ${map.keyValuePairs()}") // [(1, One), (2, Two), ..., (16, Sixteen)]

    map[1] = "One~!"
    println("Key-Value pairs: ${map.keyValuePairs()}") // [(1, One), (2, Two), ..., (16, Sixteen)]

}