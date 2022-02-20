package com.github.sharalek.freecodecamp.graphalgorithms.graphtraversal

class Traversal {

    /* dfs using stack */
    /*fun depthFirstPrint(graph: Map<Char, CharArray>, source: Char) {
        val stack = ArrayDeque<Char>()
        stack.addFirst(source)

        while (stack.isNotEmpty()) {
            val current = stack.removeFirst()
            println(current)
            for(neighbor in graph[current]!!) {
                stack.addFirst(neighbor)
            }
        }
    }*/

    /*dfs using recursion*/
    fun depthFirstPrint(graph: Map<Char, CharArray>, source: Char) {
        println(source)

        for (neighbor in graph[source]!!) {
            depthFirstPrint(graph, neighbor)
        }
    }

    fun breadthFirstPrint(graph: Map<Char, CharArray>, source: Char) {
        val queue = ArrayDeque<Char>()
        queue.add(source)

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            println(current)
            for (neighbor in graph[current]!!) {
                queue.addLast(neighbor)
            }
        }
    }

}

fun main() {

    val runner = Traversal()

    val graph = hashMapOf<Char, CharArray>(
        'a' to charArrayOf('c', 'b'),
        'b' to charArrayOf('d'),
        'c' to charArrayOf('e'),
        'd' to charArrayOf('f'),
        'e' to charArrayOf(),
        'f' to charArrayOf()
    )

    //runner.depthFirstPrint(graph, 'a')
    runner.breadthFirstPrint(graph, 'a')
}