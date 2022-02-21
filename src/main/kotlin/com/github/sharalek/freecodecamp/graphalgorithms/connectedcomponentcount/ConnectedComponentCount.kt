package com.github.sharalek.freecodecamp.graphalgorithms.connectedcomponentcount

class ConnectedComponentCount {
    fun connectedComponentCount(graph:  HashMap<Int, IntArray> ): Int {
        var count = 0
        val visited = HashSet<Int>()

        graph.keys.forEach {
            println(visited)
            if (explore(graph, it, visited) == true) count++
        }

        return count
    }

    private fun explore(graph: HashMap<Int, IntArray>, current: Int, visited: HashSet<Int>): Boolean {

        if (visited.contains(current)) return false
        visited.add(current)

        for(neighbor in graph[current]!!) {
            explore(graph, neighbor, visited)
        }

        return true
    }
}

fun main() {
    val runner = ConnectedComponentCount()

    val graph = hashMapOf(
        0 to intArrayOf(8, 5, 1),
        1 to intArrayOf(0),
        5 to intArrayOf(0, 8),
        8 to intArrayOf(0, 5),
        2 to intArrayOf(3, 4),
        3 to intArrayOf(2, 4),
        4 to intArrayOf(3, 2)
    )

    println(runner.connectedComponentCount(graph)) //2
}

