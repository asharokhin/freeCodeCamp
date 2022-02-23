package com.github.sharalek.freecodecamp.binarytreealgorithms.treeminvalue

import java.util.*

class Node(var value: Int) {
    var left: Node? = null
    var right: Node? = null
}

class TreeMinValue {
    fun treeMinValue(root: Node?): Int {
        var smallest = Int.MAX_VALUE
        val stack = LinkedList<Node?>()
        stack.push(root)

        while (stack.isNotEmpty()) {
            val current = stack.pop()
            if (current!!.value < smallest) smallest = current.value

            if (current?.left != null) stack.push(current.left)
            if (current?.right != null) stack.push(current.right)
        }

        return smallest
    }


}

fun main() {
    val runner = TreeMinValue()
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

    println(runner.treeMinValue(a))  // -2
}