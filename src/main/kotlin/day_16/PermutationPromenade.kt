package day_16

import java.io.File

class PermutationPromenade {

    fun partOne(programsString: String, moves: List<String>): String {
        var programs = programsString.toList()

        for (move in moves) {
            when {
                move.startsWith("s") -> {
                    val x = move.substring(1).toInt()
                    programs = spin(programs, x)
                }
                move.startsWith("x") -> {
                    val indices = move.substring(1).split("/").map { it.toInt() }
                    programs = exchange(programs, indices[0], indices[1])
                }
                move.startsWith("p") -> {
                    val elements = move.substring(1).split("/").map { it[0] }
                    programs = partner(programs, elements[0], elements[1])
                }
            }
        }

        return programs.joinToString("")
    }

    fun partTwo(programsString: String, moves: List<String>): String {
        var programs = programsString

        for (i in 0 until 1_000_000_000 % findCycleLength(programsString, moves)) {
            programs = partOne(programs, moves)
        }

        return programs
    }

    private fun spin(programs: List<Char>, x: Int): List<Char> {
        val suffix = programs.subList(programs.size - x, programs.size)
        val prefix = programs.subList(0, programs.size - x)
        return suffix + prefix
    }

    private fun exchange(programs: List<Char>, a: Int, b: Int): List<Char> {
        val mutablePrograms = programs.toMutableList()

        val aux = mutablePrograms[a]
        mutablePrograms[a] = mutablePrograms[b]
        mutablePrograms[b] = aux

        return mutablePrograms
    }

    private fun partner(programs: List<Char>, a: Char, b: Char): List<Char> {
        val mutablePrograms = programs.toMutableList()
        val indexOfA = mutablePrograms.indexOf(a)
        val indexOfB = mutablePrograms.indexOf(b)
        mutablePrograms[indexOfA] = b
        mutablePrograms[indexOfB] = a

        return mutablePrograms
    }

    private fun findCycleLength(programsString: String, moves: List<String>): Int {
        var programs = programsString
        var cycleLength = 0

        do {
            programs = partOne(programs, moves)
            cycleLength++
        } while (programs != programsString)

        return cycleLength
    }
}

fun main(args: Array<String>) {
    val moves = File("src/main/resources/day_16/moves.txt").readText().split(",").toList()

    println(PermutationPromenade().partOne("abcdefghijklmnop", moves))
    println(PermutationPromenade().partTwo("abcdefghijklmnop", moves))
}