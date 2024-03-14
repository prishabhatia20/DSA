fun floydWarshall(graph: Matrix, dist: Matrix, prev: Matrix):Matrix {
    // dist -> matrix size graph -- all values INFINITY
    // prev -> matrix size graph -- all values null

    val graph_size = graph.get_size()
    for (i in 0..< graph_size) {
        for (j in 0..< graph_size) {
            dist.set_value(i, j, graph.get_value(i, j))
            prev.set_value(i, j, i.toDouble())
        }
    }

    for (i in 0..< graph_size) {
        dist.set_value(i, i, 0.0)
        prev.set_value(i, i, i.toDouble())
    }

    for (k in 0..< graph_size) {
        for (i in 0..< graph_size) {
            for (j in 0..< graph_size) {
                if (dist.get_value(i, j) > (dist.get_value(i, k) + dist.get_value(k, j))) {
                    val set_dist = dist.get_value(i, k) + dist.get_value(k, j)
                    dist.set_value(i, j, set_dist)
                    prev.set_value(i, j, prev.get_value(k, j))
                }
            }
        }
    }

//    for (i in 0..< graph_size) {
//        for (j in 0..< graph_size) {
//            print(" ${dist.get_value(i, j)} ")
//        }
//        println()
//    }


    return prev

}

fun backtrace(prev: Matrix, start: Int, end: Int): MutableList<Int> {

    var path: MutableList<Int>  = mutableListOf()

    if (prev.get_value(start, end) == null) {
        return path
    }

    path.add(0, end)
    var j = end
    while (start != j) {
        j = prev.get_value(start, j).toInt()
        path.add(0, j)
    }
    return path

}
