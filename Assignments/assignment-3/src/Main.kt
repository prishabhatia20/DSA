fun main() {
    val graph = DirectedGraph<Int>()

    // Using the first weighted graph here: https://hyperskill.org/learn/step/5645
    graph.addEdge(0, 1, 3.0)
    graph.addEdge(0, 3, 7.0)
    graph.addEdge(0, 4, 8.0)
    graph.addEdge(1, 2, 1.0)
    graph.addEdge(1, 3, 4.0)
    graph.addEdge(3, 2, 2.0)
    graph.addEdge(4, 3, 3.0)


    println(dijkstra(4, 2, graph))

    // Aerial distances between Indian cities -- map below
    // https://docs.google.com/document/d/1gFtDOyUKDnkpXlHKFhLghKb8Q5zODYSXw2PucDWu1Qo/edit?usp=sharing
    // Distances in kms

    val city_graph = DirectedGraph<String>()
    city_graph.addEdge("New Delhi", "Jaipur", 241.0)
    city_graph.addEdge("New Delhi", "Nagpur", 852.0)
    city_graph.addEdge("New Delhi", "Lucknow", 419.0)

    city_graph.addEdge("Lucknow", "New Delhi", 419.0)
    city_graph.addEdge("Lucknow", "Nagpur", 655.0)
    city_graph.addEdge("Lucknow", "Patna", 447.0)

    city_graph.addEdge("Patna", "Lucknow", 447.0)
    city_graph.addEdge("Patna", "Nagpur", 787.0)
    city_graph.addEdge("Patna", "Kolkata", 447.0)

    city_graph.addEdge("Kolkata", "Patna", 462.0)
    city_graph.addEdge("Kolkata", "Nagpur", 964.0)
    city_graph.addEdge("Kolkata", "Hyderabad", 1180.0)
    city_graph.addEdge("Kolkata", "Chennai", 1366.0)

    city_graph.addEdge("Jaipur", "New Delhi", 241.0)
    city_graph.addEdge("Jaipur", "Nagpur", 727.0)
    city_graph.addEdge("Jaipur", "Ahmedabad", 534.0)

    city_graph.addEdge("Ahmedabad", "Jaipur", 534.0)
    city_graph.addEdge("Ahmedabad", "Nagpur", 706.0)
    city_graph.addEdge("Ahmedabad", "Hyderabad", 876.0)
    city_graph.addEdge("Ahmedabad", "Nagpur", 706.0)
    city_graph.addEdge("Ahmedabad", "Pune", 518.0)
    city_graph.addEdge("Ahmedabad", "Surat", 210.0)

    city_graph.addEdge("Nagpur", "Hyderabad", 422.0)
    city_graph.addEdge("Nagpur", "Kolkata", 964.0)
    city_graph.addEdge("Nagpur", "Patna", 787.0)
    city_graph.addEdge("Nagpur", "Lucknow", 655.0)
    city_graph.addEdge("Nagpur", "New Delhi", 852.0)
    city_graph.addEdge("Nagpur", "Jaipur", 727.0)
    city_graph.addEdge("Nagpur", "Ahmedabad", 706.0)

    city_graph.addEdge("Hyderabad", "Kolkata", 1180.0)
    city_graph.addEdge("Hyderabad", "Nagpur", 422.0)
    city_graph.addEdge("Hyderabad", "Ahmedabad", 876.0)
    city_graph.addEdge("Hyderabad", "Pune", 504.0)
    city_graph.addEdge("Hyderabad", "Chennai", 521.0)

    city_graph.addEdge("Pune", "Hyderabad", 504.0)
    city_graph.addEdge("Pune", "Ahmedabad", 518.0)
    city_graph.addEdge("Pune", "Surat", 310.0)
    city_graph.addEdge("Pune", "Mumbai", 118.0)
    city_graph.addEdge("Pune", "Bengaluru", 734.0)
    city_graph.addEdge("Pune", "Chennai", 912.0)

    city_graph.addEdge("Surat", "Ahmedabad", 210.0)
    city_graph.addEdge("Surat", "Pune", 310.0)
    city_graph.addEdge("Surat", "Mumbai", 231.0)

    city_graph.addEdge("Mumbai", "Surat", 231.0)
    city_graph.addEdge("Mumbai", "Pune", 118.0)
    city_graph.addEdge("Mumbai", "Bengaluru", 842.0)

    city_graph.addEdge("Bengaluru", "Mumbai", 842.0)
    city_graph.addEdge("Bengaluru", "Pune", 734.0)
    city_graph.addEdge("Bengaluru", "Chennai", 284.0)

    city_graph.addEdge("Chennai", "Bengaluru", 284.0)
    city_graph.addEdge("Chennai", "Pune", 912.0)
    city_graph.addEdge("Chennai", "Hyderabad", 521.0)
    city_graph.addEdge("Chennai", "Kolkata", 1366.0)

    println("Chennai to Delhi: " + dijkstra("Chennai", "New Delhi", city_graph))
    println("Mumbai to Kolkata: " + dijkstra("Mumbai", "Kolkata", city_graph))
    println("Chennai to Jaipur: " + dijkstra("Chennai", "Jaipur", city_graph))
    println("Patna to Bengaluru: " + dijkstra("Patna", "Bengaluru", city_graph))
    println("Pune to Lucknow: " + dijkstra("Pune", "Lucknow", city_graph))






















}