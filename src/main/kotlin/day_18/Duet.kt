package day_18

import java.io.File

class Duet {

    fun partOne(instructions: List<String>): Long {
        var idx = 0
        val registers = mutableMapOf<String, Long>()
        var sound: Long = 0

        while (true) {
            if (instructions[idx].startsWith("set")) {
                val parts = instructions[idx].substring(4).split(" ")
                val value = try {
                    parts[1].toLong()
                } catch (e: Exception) {
                    registers[parts[1]] ?: 0
                }

                registers.put(parts[0], value)
            } else if (instructions[idx].startsWith("add")) {
                val parts = instructions[idx].substring(4).split(" ")
                val value = try {
                    parts[1].toLong()
                } catch (e: Exception) {
                    registers[parts[1]] ?: 0
                }

                if (registers.containsKey(parts[0])) {
                    registers.put(parts[0], registers.getValue(parts[0]) + value)
                } else {
                    registers.put(parts[0], value)
                }
            } else if (instructions[idx].startsWith("mul")) {
                val parts = instructions[idx].substring(4).split(" ")
                val value = try {
                    parts[1].toLong()
                } catch (e: Exception) {
                    registers[parts[1]] ?: 0
                }

                if (registers.containsKey(parts[0])) {
                    registers.put(parts[0], registers.getValue(parts[0]) * value)
                } else {
                    registers.put(parts[0], 0)
                }
            } else if (instructions[idx].startsWith("mod")) {
                val parts = instructions[idx].substring(4).split(" ")
                val value = try {
                    parts[1].toLong()
                } catch (e: Exception) {
                    registers[parts[1]] ?: 0
                }

                if (registers.containsKey(parts[0])) {
                    registers.put(parts[0], registers.getValue(parts[0]) % value)
                } else {
                    registers.put(parts[0], 0)
                }
            } else if (instructions[idx].startsWith("jgz")) {
                val parts = instructions[idx].substring(4).split(" ")
                val value = try {
                    parts[1].toLong()
                } catch (e: Exception) {
                    registers[parts[1]] ?: 0
                }

                if (registers.containsKey(parts[0]) && registers.getValue(parts[0]) > 0) {
                    idx += value.toInt()
                    continue
                }
            } else if (instructions[idx].startsWith("snd")) {
                val register = instructions[idx].substring(4)
                if (registers.containsKey(register)) {
                    sound = registers.getValue(register)
                } else {
                    sound = 0
                }
            } else if (instructions[idx].startsWith("rcv")) {
                val parts = instructions[idx].substring(4).split(" ")
                if (registers.containsKey(parts[0]) && registers.getValue(parts[0]) != 0L) {
                    registers.put(parts[0], sound)
                    return sound
                }
            }

            idx++
        }
    }

    fun partTwo(instructions: List<String>): Long {
        var idxA = 0
        var idxB = 0
        val registersA = mutableMapOf<String, Long>()
        val registersB = mutableMapOf<String, Long>()
        val queueA = mutableListOf<Long>()
        val queueB = mutableListOf<Long>()
        var count = 0

        while (true) {
            if (instructions[idx].startsWith("set")) {
                val parts = instructions[idx].substring(4).split(" ")
                val value = try {
                    parts[1].toLong()
                } catch (e: Exception) {
                    registers[parts[1]] ?: 0
                }

                registers.put(parts[0], value)
            } else if (instructions[idx].startsWith("add")) {
                val parts = instructions[idx].substring(4).split(" ")
                val value = try {
                    parts[1].toLong()
                } catch (e: Exception) {
                    registers[parts[1]] ?: 0
                }

                if (registers.containsKey(parts[0])) {
                    registers.put(parts[0], registers.getValue(parts[0]) + value)
                } else {
                    registers.put(parts[0], value)
                }
            } else if (instructions[idx].startsWith("mul")) {
                val parts = instructions[idx].substring(4).split(" ")
                val value = try {
                    parts[1].toLong()
                } catch (e: Exception) {
                    registers[parts[1]] ?: 0
                }

                if (registers.containsKey(parts[0])) {
                    registers.put(parts[0], registers.getValue(parts[0]) * value)
                } else {
                    registers.put(parts[0], 0)
                }
            } else if (instructions[idx].startsWith("mod")) {
                val parts = instructions[idx].substring(4).split(" ")
                val value = try {
                    parts[1].toLong()
                } catch (e: Exception) {
                    registers[parts[1]] ?: 0
                }

                if (registers.containsKey(parts[0])) {
                    registers.put(parts[0], registers.getValue(parts[0]) % value)
                } else {
                    registers.put(parts[0], 0)
                }
            } else if (instructions[idx].startsWith("jgz")) {
                val parts = instructions[idx].substring(4).split(" ")
                val value = try {
                    parts[1].toLong()
                } catch (e: Exception) {
                    registers[parts[1]] ?: 0
                }

                if (registers.containsKey(parts[0]) && registers.getValue(parts[0]) > 0) {
                    idx += value.toInt()
                    continue
                }
            } else if (instructions[idx].startsWith("snd")) {
                val register = instructions[idx].substring(4)
                if (registers.containsKey(register)) {
                    sound = registers.getValue(register)
                } else {
                    sound = 0
                }
            } else if (instructions[idx].startsWith("rcv")) {
                val parts = instructions[idx].substring(4).split(" ")
                if (registers.containsKey(parts[0]) && registers.getValue(parts[0]) != 0L) {
                    registers.put(parts[0], sound)
                    return sound
                }
            }

            idx++
        }
    }
}

fun main(args: Array<String>) {
//    val moves = File("src/main/resources/day_18/moves.txt").readText().split("\n").toList()
    val moves = File("src/main/resources/day_18/moves_1.txt").readText().split("\n").toList()

    println(Duet().partOne(moves))
//    println(PermutationPromenade().partTwo("abcdefghijklmnop", moves))
}