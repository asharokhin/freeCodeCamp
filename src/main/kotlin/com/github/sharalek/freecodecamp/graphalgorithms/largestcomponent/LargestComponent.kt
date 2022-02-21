package com.github.sharalek.freecodecamp.graphalgorithms.largestcomponent

class LargestComponent {

    fun largestComponent(graph:  HashMap<Int, IntArray>): Int {
        val visited = HashSet<Int>()
        var longest = 0

        for (node in graph.keys) {
            val size = exploreSize(graph, node, visited)
            longest = maxOf(longest, size)
        }

        return longest
    }

    private fun exploreSize(graph: HashMap<Int, IntArray>, node: Int, visited: HashSet<Int>): Int {
        if (visited.contains(node)) return 0

        visited.add(node)

        var size = 1

        for (neighbor in graph[node]!!) {
            size += exploreSize(graph, neighbor, visited)
        }

        return size
    }


    /*My attempt to solve the problem*/
    fun largestComponentAttempt(graph:  HashMap<Int, IntArray>): Int {
        val visited = HashSet<Int>()
        var largest = 0
        var prevComponentSize = 0

        graph.keys.forEach {
            if (explore(graph, it, visited)) {
                val size = visited.size - prevComponentSize

                prevComponentSize = visited.size
                largest = maxOf(largest, size)
            }
        }
        return largest
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
    val runner = LargestComponent()

    val graph = hashMapOf(
        0 to intArrayOf(8, 5, 1),
        1 to intArrayOf(0),
        5 to intArrayOf(0, 8),
        8 to intArrayOf(0, 5),
        2 to intArrayOf(3, 4),
        3 to intArrayOf(2, 4),
        4 to intArrayOf(3, 2)
    )

    println(runner.largestComponent(graph))
}