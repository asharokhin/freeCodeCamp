package com.github.sharalek.freecodecamp.graphalgorithms.haspath

import com.github.sharalek.freecodecamp.graphalgorithms.graphtraversal.Traversal

class HasPath {

    /* hasPath function takes adjacency list of a directed acyclic graph and two nodes.
    * and returns a boolean indicating whether or not there exists a directed path between two nodes.*/

    /* dfs traversal */
    fun hasPath_dfs(graph: Map<Char, CharArray>, src: Char, dst: Char): Boolean {
        if (src == dst) return true

        graph[src]?.forEach {
            if (hasPath(graph, it, dst)) {
                return true
            }
        }

        return false
    }

    /* bfs traversal*/
    fun hasPath(graph: Map<Char, CharArray>, src: Char, dst: Char): Boolean {
        val queue = ArrayDeque<Char>()
        queue.add(src)

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            if (current == dst) return true

            graph[current]?.forEach {
                queue.addLast(it)
            }
        }

        return false
    }
}

fun main() {

    val runner = HasPath()

    val graph = hashMapOf<Char, CharArray>(
        'f' to charArrayOf('g', 'i'),
        'g' to charArrayOf('h'),
        'h' to charArrayOf(),
        'i' to charArrayOf('g', 'k'),
        'j' to charArrayOf('i'),
        'k' to charArrayOf()
    )

    val isConnected: Boolean = runner.hasPath(graph, 'j', 'f') //false
    //isConnected = runner.hasPath(graph, 'f', 'k') //true
    println(isConnected)
}