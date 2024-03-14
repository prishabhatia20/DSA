fun main() {
    val graph1 = Matrix(4)

    val INFINITY = Int.MAX_VALUE
    val graph1_list:MutableList<Int> = mutableListOf(0, INFINITY, -2, INFINITY, 4, 0, 3, INFINITY, INFINITY, INFINITY, 0, 2, INFINITY, -1, INFINITY, 0)

    var count = 0
    for (i in 0..<graph1.get_size()) {
        for (j in 0..<graph1.get_size()) {
            val put = graph1_list[count]
            graph1.set_value(i, j, put.toDouble())
            count++
        }
    }

    val dist1 = Matrix(4)
    for (i in 0..< dist1.get_size()) {
        for (j in 0..< dist1.get_size()) {
            dist1.set_value(i, j, INFINITY.toDouble())
        }
    }

    val prev1 = Matrix(4)
    for (i in 0..< prev1.get_size()) {
        for (j in 0..< prev1.get_size()) {
            dist1.set_value(i, j, null)
        }
    }

    val output1 = floydWarshall(graph1, dist1, prev1)

    for (i in 0..< prev1.get_size()) {
        for (j in 0..< prev1.get_size()) {
            print(" ${output1.get_value(i, j)} ")
        }
        println()
    }


    val path = backtrace(output1, 0, 0)
    print(path)

}