package com.github.sharalek.freecodecamp.binarytreealgorithms.treesum

class Node(var value: Int) {
    var left: Node? = null
    var right: Node? = null
}
class TreeSum {
    fun treeSum(root: Node?):Int {
        if (root == null) return 0
        var totalSum = root.value
        val queue = ArrayDeque<Node?>()
        queue.addFirst(root)

        while (queue.isNotEmpty()) {
            val current = queue.removeFirst()

            if(current?.left != null) {
                queue.addLast(current.left)
                totalSum += current.left!!.value
            }
            if(current?.right != null) {
                queue.addLast(current.right)
                totalSum += current.right!!.value
            }

        }
        return totalSum
    }
}

fun main() {
    val runner = TreeSum()

    val nodeA = Node(1)
    val nodeB = Node(6)
    val nodeC = Node(0)
    val nodeD = Node(3)
    val nodeE = Node(-6)
    val nodeF = Node(2)
    val nodeG = Node(2)
    val nodeH = Node(2)

    nodeA.left = nodeB
    nodeA.right = nodeC

    nodeB.left = nodeD
    nodeB.right = nodeE

    nodeE.left = nodeG
    nodeC.right = nodeF
    nodeF.right = nodeH

    println(runner.treeSum(nodeA)) //10



}