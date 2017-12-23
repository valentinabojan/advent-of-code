package day_22

import java.io.File

class SporificaVirus {

    private val CLEAN = "."
    private val INFECTED = "#"
    private val FLAGGED = "F"
    private val WEAKENED = "W"

    fun partOne(inputMap: List<List<String>>, iterations: Int): Int {
        val map = inputMap.map { it.toMutableList() }.toMutableList()
        val directionComputer = DirectionComputer()

        var x = map.size/2
        var y = map.size/2
        var cellsGotInfected = 0
        var direction = "up"
        var next: Triple<String, Int, Int>

        for (i in 0 until iterations) {
            if (map[x][y] == CLEAN) {
                map[x][y] = INFECTED
                cellsGotInfected++
                next = directionComputer.moveLeft(direction, x, y)
            } else {
                map[x][y] = CLEAN
                next = directionComputer.moveRight(direction, x, y)
            }

            direction = next.first
            x = next.second
            y = next.third

            extendMap(map, x, y)
            x = if (x < 0) x + 1 else x
            y = if (y < 0) y + 1 else y
        }

        return cellsGotInfected
    }


    fun partTwo(inputMap: List<List<String>>, iterations: Int): Int {
        val map = inputMap.map { it.toMutableList() }.toMutableList()
        val directionComputer = DirectionComputer()

        var x = map.size/2
        var y = map.size/2
        var cellsGotInfected = 0
        var direction = "up"
        var next: Triple<String, Int, Int>

        for (i in 0 until iterations) {
            when {
                map[x][y] == CLEAN -> {
                    map[x][y] = WEAKENED
                    next = directionComputer.moveLeft(direction, x, y)
                }
                map[x][y] == WEAKENED -> {
                    map[x][y] = INFECTED
                    cellsGotInfected++
                    next = directionComputer.moveForward(direction, x, y)
                }
                map[x][y] == INFECTED -> {
                    map[x][y] = FLAGGED
                    next = directionComputer.moveRight(direction, x, y)
                }
                else -> {
                    map[x][y] = CLEAN
                    next = directionComputer.moveBackward(direction, x, y)
                }
            }

            direction = next.first
            x = next.second
            y = next.third

            extendMap(map, x, y)
            x = if (x < 0) x + 1 else x
            y = if (y < 0) y + 1 else y
        }

        return cellsGotInfected
    }

    private fun extendMap(map: MutableList<MutableList<String>>, x: Int, y: Int) {
        when {
            x < 0 -> {
                map.add(0, map[0].map { CLEAN }.toMutableList())
            }
            x >= map.size -> {
                map.add(map[0].map { CLEAN }.toMutableList())
            }
            y < 0 -> {
                map.forEach{ it.add(0, CLEAN) }
            }
            y >= map[x].size -> {
                map.forEach { it.add(CLEAN) }
            }
        }
    }

    fun readFile(path: String): MutableList<List<String>> {
        val map = mutableListOf<List<String>>()
        File(path).forEachLine {
            map.add(it.toCharArray().map { it + "" }.toMutableList())
        }
        return map
    }
}

fun main(args: Array<String>) {
    val map = SporificaVirus().readFile("src/main/resources/day_22/map.txt")

    println(SporificaVirus().partOne(map, 10_000))         // 5305
    println(SporificaVirus().partTwo(map, 10_000_000))     // 2511424
}