package com.github.sharalek.freecodecamp.graphalgorithms.shortestpath

class ShortestPath {

    fun shortestPath(edges: Array<CharArray>, src: Char, dst: Char):Int {

        val graph = buildGraph(edges)
        val visited = HashSet<Char>(listOf(src))
        val queue = ArrayDeque(listOf(Pair(src, 0)))

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            val node = current.first
            val distance = current.second

            if (current.first == dst) return distance

            for (neighbor in graph[node]!!) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor)
                    queue.addLast( Pair(neighbor, distance + 1) )
                }
            }
        }

        return -1
    }

    private fun buildGraph(edges: Array<CharArray>): HashMap<Char, ArrayList<Char>> {
        val map = HashMap<Char, ArrayList<Char>>()

        for (edge in edges) {
            val a = edge[0]
            val b = edge[1]

            if (!map.containsKey(a)) map[a] = ArrayList()
            if (!map.containsKey(b)) map[b] = ArrayList()

            map[a]?.add(b)
            map[b]?.add(a)
        }

        return map
    }
}

fun main() {
    val edges = arrayOf(
        charArrayOf('w', 'x'),
        charArrayOf('x', 'y'),
        charArrayOf('z', 'y'),
        charArrayOf('z', 'v'),
        charArrayOf('w', 'v'),
        charArrayOf('z', 'g'),
        charArrayOf('a', 'b'),
    )

    val runner = ShortestPath()

    println(runner.shortestPath(edges, 'w', 'z')) //2
    println(runner.shortestPath(edges, 'z', 'b')) //-1

}