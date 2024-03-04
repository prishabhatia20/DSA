import kotlin.time.measureTime// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import kotlin.random.Random

fun main() {

    val sizes = mutableListOf(2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096)

    println("Size   Normal   Strassen")
    for (i in 0..<sizes.size) {
        val matrix1 = Matrix(sizes[i])
        val matrix2 = Matrix(sizes[i])

        for (j in 0..<sizes[i]) {
            for (k in 0..<sizes[i]) {
                matrix1.set_value(j, k, Random.nextInt(0, 100).toDouble())
            }
        }

        for (j in 0..<sizes[i]) {
            for (k in 0..<sizes[i]) {
                matrix2.set_value(j, k, Random.nextInt(0, 100).toDouble())
            }
        }

        val strassen_time = measureTime {
            matrix1.strassenMultiply(matrix2)
        }
        val normal_time = measureTime{
            matrix1.multiply(matrix2)
        }

        println("${sizes[i]}  |  $normal_time  |  $strassen_time")

    }

    println("Strassen beats normal multiplication at a matrix size of 1024")



    val a = "GGTTGACTA"
    val b = "TGTTACGG"

    val smith = smith_waterman(a, b, 3, -2)
    println("Smith Waterman: $smith")
}