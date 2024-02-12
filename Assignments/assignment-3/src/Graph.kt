/**
 * This is a simple ``Graph`` that represents a directed graph
 * @param VertexType the representation of a vertex in the graph
 */
interface Graph<VertexType> {
    /**
     * @return the vertices in the graph
     */
    fun getVertices(): Set<VertexType>

    /**
     * Add an
     */
    fun addEdge(from: VertexType, to: VertexType, cost: Double)

    /**
     *
     */
    fun getEdges(from: VertexType): Map<VertexType, Double>

    /**
     * Remove all edges and vertices from the graph
     */
    fun clear()
}

class DirectedGraph<VertexType>: Graph<VertexType> {

    private var map: MutableMap<VertexType, MutableMap<VertexType, Double>> = mutableMapOf()


    /**
     * This method returns all the vertices in the graph
     *
     * @return the vertices in the graph
     */
    override fun getVertices(): Set<VertexType> {
        return map.keys
    }

    /**
     * This method clears the graph -- makes it so that the
     * graph is empty
     */
    override fun clear() {
        map = mutableMapOf()
    }

    /**
     * This method returns a given vertex's neighbors and
     * the cost of the edges connected to those neighbors
     *
     * @param from the edge that the user wants the neighbors of
     * @return a map containing the neighboring vertex and the edge cost
     */
    override fun getEdges(from: VertexType): Map<VertexType, Double> {
        return map[from]?: mutableMapOf()
    }

    /**
     * Add an edge to the graph
     *
     * @param from the start vertex connecting to the new edge
     * @param to the end vertex that connects with from
     * @param cost the cost to get between from and to
     */
    override fun addEdge(from: VertexType, to: VertexType, cost: Double) {
        map[from]?.also{connections ->
            connections[to] = cost
        } ?: run{
            map[from] = mutableMapOf(to to cost)
        }
        if (map[to] == null) {
            map[to] = mutableMapOf()
        }
    }


}