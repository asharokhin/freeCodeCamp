package com.github.sharalek.freecodecamp.binarytreealgorithms.maxroottoleafpath

class Node(var value: Int) {
    var left: Node? = null
    var right: Node? = null
}

class MaxPath {
    fun maxPathSum(root: Node?): Int {
        if (root == null) return Int.MIN_VALUE
        if (root.left == null && root.right == null) return root.value
        val maxChildPathSum = maxOf(maxPathSum(root.left), maxPathSum(root.right))

        return maxChildPathSum + root.value
    }

}

fun main() {
    val runner = MaxPath()

    val a = Node(3)
    val b = Node(11)
    val c = Node(4)
    val d = Node(4)
    val e = Node(-2)
    val f = Node(1)

    a.left = b
    a.right = c
    b.left = d
    b.right = e
    c.right = f

//    3
//   /  \
//  11   4
//  / \    \
// 4   -2   1

    println(runner.maxPathSum(a))  // -2
}