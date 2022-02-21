package com.github.sharalek.freecodecamp.graphalgorithms.minimumisland



class MinimumIsland {
    fun minimumIsland(grid: Array<CharArray>): Int {
        var minSize = Int.MAX_VALUE
        val visited = HashSet<String>()

        for(r in grid.indices) {
            for (c in grid[0].indices) {
                val size = explore(grid, r, c, visited)
                if (size > 0) {
                    minSize = minOf(size, minSize)
                }
            }
        }

        return minSize
    }

    private fun explore(grid: Array<CharArray>, r: Int, c: Int, visited: HashSet<String>): Int {
        val rowInbounds = (0 <= r && r < grid.size)
        val colInbounds = (0 <= c && c < grid[0].size)

        if (!rowInbounds || !colInbounds) return 0
        if (grid[r][c] == 'W') return 0

        val pos = String.format("$r,$c")

        if (visited.contains(pos)) return 0
        visited.add(pos)

        var size = 1

        size += explore(grid, r - 1, c, visited)
        size += explore(grid, r + 1, c, visited)
        size += explore(grid, r, c - 1, visited)
        size += explore(grid, r, c + 1, visited)

        return size
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

    val runner = MinimumIsland()

    println(runner.minimumIsland(grid))

}