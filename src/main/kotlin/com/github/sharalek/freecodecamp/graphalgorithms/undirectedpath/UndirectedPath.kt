package com.github.sharalek.freecodecamp.graphalgorithms.undirectedpath


class UndirectedPath {
    fun undirectedPath(edges:  Array<CharArray>, nodeA: Char, nodeB: Char): Boolean {
        val graph = buildGraph(edges)
        
        return hasPath(graph, nodeA, nodeB, HashSet<Char>())
    }

    private fun hasPath(graph: HashMap<Char, ArrayList<Char>>, src: Char, dst: Char, visited: HashSet<Char>): Boolean {
        if (visited.contains(src)) return false
        if (src == dst) return true

        visited.add(src)

        graph[src]?.forEach{
            if (hasPath(graph, it, dst, visited)) {
                return true
            }
        }

        return false
    }

    /*Converts edge list to adjacency list*/
    private fun buildGraph(edges: Array<CharArray>): HashMap<Char, ArrayList<Char>> {
        val graph = HashMap<Char, ArrayList<Char>>()

        edges.forEach {
            val a = it[0]
            val b = it[1]
            if(!graph.containsKey(a)) graph[a] = ArrayList<Char>()
            if(!graph.containsKey(b)) graph[b] = ArrayList<Char>()

            graph[a]?.add(b)
            graph[b]?.add(a)
        }

        return graph
    }

}

fun main() {
    val runner = UndirectedPath()

    val edges = arrayOf(
        charArrayOf('i', 'j'),
        charArrayOf('k', 'i'),
        charArrayOf('m', 'k'),
        charArrayOf('k', 'l'),
        charArrayOf('o', 'n'),
    )

    val result = runner.undirectedPath(edges, 'j', 'm') //true

    println(result)
}