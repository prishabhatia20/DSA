import kotlin.system.measureTimeMillis
import kotlin.random.Random



fun main() {

    val random = Random(System.currentTimeMillis())

    val sort = mutableListOf(3, 2, 9, 40, 2, 1, 0)

    val heap = MinHeap()

    for (i in 0..sort.lastIndex) {
        heap.insert(sort[i])
    }

}