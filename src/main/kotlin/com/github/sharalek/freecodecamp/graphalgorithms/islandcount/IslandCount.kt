package com.github.sharalek.freecodecamp.graphalgorithms.islandcount

class IslandCount {
    fun islandCount(grid: Array<CharArray>): Int {
        val visited = HashSet<String>()
        var count = 0

        for (row in grid.indices) {
            for (column in grid[0].indices) {
                if (explore(grid, row, column, visited)) count++
            }
        }

        return count
    }

    private fun explore(grid: Array<CharArray>, row: Int, column: Int, visited: HashSet<String>): Boolean {

        val rowInbounds = (0 <= row && row < grid.size)
        val colInbounds = (0 <= column && column < grid[0].size)

        if (!rowInbounds || !colInbounds) return false
        if (grid[row][column] == 'W') return false

        val pos = String.format("$row,$column")

        if (visited.contains(pos)) return false
        visited.add(pos)

        explore(grid, row - 1, column, visited)
        explore(grid, row + 1, column, visited)
        explore(grid, row, column - 1, visited)
        explore(grid, row, column + 1, visited)

        return true
    }


}

fun main() {
    val grid = arrayOf(
        charArrayOf('W', 'L', 'W', 'W', 'W'),
        charArrayOf('W', 'L', 'W', 'W', 'W'),
        charArrayOf('W', 'W', 'W', 'L', 'W'),
        charArrayOf('W', 'W', 'L', 'L', 'W'),
        charArrayOf('L', 'W', 'W', 'L', 'L'),
        charArrayOf('L', 'L', 'W', 'W', 'W'),
    )

    val runner = IslandCount()

    println(runner.islandCount(grid))

}