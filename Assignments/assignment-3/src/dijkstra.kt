fun <VertexType>dijkstra(source: VertexType, end: VertexType, graph: DirectedGraph<VertexType>): MutableList<VertexType> {
    val prev: MutableMap<VertexType, VertexType?> = mutableMapOf()
    val dist: MutableMap<VertexType, Double> = mutableMapOf()
    val queue = PriorityQueue<VertexType>()

    for (vertex in graph.getVertices()) {
        if (vertex != source) {
            prev[vertex] = null
            dist[vertex] = Double.MAX_VALUE
            queue.addWithPriority(vertex, Double.MAX_VALUE )
        }
    }

    dist[source] = 0.0
    queue.addWithPriority(source, 0.0)

    while (!queue.isEmpty()) {
        val minPriority = queue.next() ?: break
        val neighbors = graph.getEdges(minPriority)

        for ((neighbor, weight) in neighbors) {
            val cost = dist[minPriority]?.plus(weight)

            if (cost != null) {
                if (cost < dist[neighbor]!!) {
                    dist[neighbor] = cost
                    queue.adjustPriority(neighbor, cost)
                    prev[neighbor] = minPriority
                }
            }

        }
    }

    var elem = prev[end]
    val path: MutableList<VertexType> = mutableListOf()
    path.add(0, end)
    while ((elem != null) && elem != source) {
        path.add(0, elem)
        val next_elem = elem
        elem = prev[next_elem]
    }
    path.add(0, source)
    return path




}