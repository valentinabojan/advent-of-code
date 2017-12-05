package day_5

import java.io.File

class Maze {

    fun computeIncrementalSteps(input: String): Int {
        val list = input.split(" ").map { i -> i.toInt() }.toMutableList()
        var idx = 0
        var steps = 0

        while (idx < list.size) {
            val nextOffset = idx.plus(list[idx])
            list[idx] = list[idx] + 1
            idx = nextOffset
            steps++
        }

        return steps
    }

    fun computeIncrementalDecrementalSteps(input: String): Int {
        val list = input.split(" ").map { i -> i.toInt() }.toMutableList()
        var idx = 0
        var steps = 0

        while (idx < list.size) {
            val nextOffset = idx.plus(list[idx])
            list[idx] = if(list[idx] < 3) (list[idx] + 1) else (list[idx] - 1)
            idx = nextOffset
            steps++
        }

        return steps
    }
}

fun main(args: Array<String>) {
    val maze = File("src/main/resources/day_5/maze.txt").readText().replace("\n", " ")

    println(Maze().computeIncrementalSteps(maze))
    println(Maze().computeIncrementalDecrementalSteps(maze))
}