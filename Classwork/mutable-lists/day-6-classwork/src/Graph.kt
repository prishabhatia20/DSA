class Graph<VertexType> {
    private var vertices: MutableSet<VertexType> = mutableSetOf()
    private var edges: MutableMap<VertexType, MutableSet<VertexType>> = mutableMapOf()

    /**
     * Add the vertex [v] to the graph
     * @param v the vertex to add
     * @return true if the vertex is successfully added, false if the vertex
     *   was already in the graph
     */
    fun addVertex(v: VertexType): Boolean {
        if (vertices.contains(v)) {
            return false
        }
        vertices.add(v)
        return true
    }

    /**
     * Add an edge between vertex [from] connecting to vertex [to]
     * @param from the vertex for the edge to originate from
     * @param to the vertex to connect the edge to
     * @return true if the edge is successfully added and false if the edge
     *     can't be added or already exists
     */
    fun addEdge(from: VertexType, to: VertexType): Boolean {
        if (!vertices.contains(from) || !vertices.contains(to)) {
            return false
        }
        edges[from]?.also { currentAdjacent ->
            if (currentAdjacent.contains(to)) {
                return false
            }
            currentAdjacent.add(to)
        } ?: run {
            edges[from] = mutableSetOf(to)
        }
        return true
    }

    /**
     * Clear all vertices and edges
     */
    fun clear() {
        vertices = mutableSetOf()
        edges = mutableMapOf()
    }

    fun bfs(start: VertexType, target: VertexType): Boolean {

        val toVisit: MutableSet<VertexType> = mutableSetOf()
        val priorityList = MyQueue<VertexType>()

        priorityList.enqueue(start)
        toVisit.add(start)

        while (!priorityList.isEmpty()) {
            val n = priorityList.dequeue()
            if (n == target) {
                return true
            }

            for (m in edges[n]?:mutableSetOf()) {
                if (!toVisit.contains(m)) {
                    priorityList.enqueue(m)
                    toVisit.add(m)
                }
            }
        }
        return false

    }

    fun dfs(start: VertexType, target: VertexType): Boolean {

        val toVisit: MutableSet<VertexType> = mutableSetOf()
        val priorityList = MyStack<VertexType>()

        priorityList.push(start)
        toVisit.add(start)

        while (!priorityList.isEmpty()) {
            val n = priorityList.pop()
            if (n == target) {
                return true
            }

            for (m in edges[n]?:mutableSetOf()) {
                if (!toVisit.contains(m)) {
                    priorityList.push(m)
                    toVisit.add(m)
                }
            }
        }
        return false

    }
}