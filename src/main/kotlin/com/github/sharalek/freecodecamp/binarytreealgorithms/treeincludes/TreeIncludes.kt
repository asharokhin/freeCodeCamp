package com.github.sharalek.freecodecamp.binarytreealgorithms.treeincludes

class Node(var value: Char) {
    var left: Node? = null
    var right: Node? = null
}

class TreeIncludes {
    fun treeIncludes(root: Node?, target: Char): Boolean {
        if (root == null) return false

        val queue =  ArrayDeque<Node?>()
        queue.addLast(root)

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()
            if (current?.value == target) {
                return true
            }
            if (current?.left != null) queue.addLast(current.left)
            if (current?.right != null) queue.addLast(current.right)
        }

        return false
    }
}

fun main() {
    val runner = TreeIncludes()

    val nodeA = Node('a')
    val nodeB = Node('b')
    val nodeC = Node('c')
    val nodeD = Node('d')
    val nodeE = Node('e')
    val nodeF = Node('f')
    val nodeG = Node('g')
    val nodeH = Node('h')

    nodeA.left = nodeB
    nodeA.right = nodeC
    nodeB.left = nodeD
    nodeB.right = nodeE
    nodeE.left = nodeG
    nodeC.right = nodeF
    nodeF.right = nodeH

    println(runner.treeIncludes(nodeA, 'p'))

}