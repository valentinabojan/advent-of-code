package day_6

import java.io.File

class MemoryReallocation {

    fun partOne(inputBlocks: List<Int>): Int {
        val allGeneratedBlocks = mutableListOf<List<Int>>()
        var blocks = inputBlocks.toList()
        var steps = 0

        while(true) {
            allGeneratedBlocks.add(blocks)

            blocks = computeNextBlocksState(blocks)
            steps++

            if (allGeneratedBlocks.contains(blocks))
                return steps
        }
    }

    fun partTwo(inputBlocks: List<Int>): Int {
        val allGeneratedBlocks = mutableMapOf<List<Int>, Int>()
        var blocks = inputBlocks.toList()
        var steps = 0

        while(true) {
            allGeneratedBlocks.put(blocks, steps)

            blocks = computeNextBlocksState(blocks)
            steps++

            if (allGeneratedBlocks.contains(blocks))
                break
        }

        return steps - allGeneratedBlocks[blocks]!!
    }

    private fun computeNextBlocksState(blocks: List<Int>): List<Int> {
        var max = blocks.max()
        val idx = blocks.indexOf(max)

        val nextBlocks = blocks.toMutableList()
        nextBlocks[idx] = 0

        var i = idx
        while (max!! > 0) {
            i = (i + 1) % nextBlocks.size
            nextBlocks[i] = nextBlocks.get(i) + 1
            max--
        }

        return nextBlocks
    }
}

fun main(args: Array<String>) {
    val maze = File("src/main/resources/day_6/memory_blocks.txt").readText().split("\t").map { it.toInt() }

    println(MemoryReallocation().partOne(maze))
    println(MemoryReallocation().partTwo(maze))
}