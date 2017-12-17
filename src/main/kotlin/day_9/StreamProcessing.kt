package day_9

import java.io.File

class StreamProcessing {

    fun computeSumOfNestedBlocks(input: String): Int {
        val stack = mutableListOf<Char>()
        var sum = 0
        var cursor = 0

        while (cursor < input.length) {
            val char = input.get(cursor)

            if ((char == '{' || char == '<') && !shouldBeGarbage(stack)) {
                stack.add(char)
            } else if (char == '}' && !shouldBeGarbage(stack)) {
                sum += stack.size
                stack.removeAt(stack.size - 1)
            } else if (char == '>') {
                stack.removeAt(stack.size - 1)
            } else if (char == '!') {
                cursor++
            }

            cursor++
        }

        return sum
    }

    private fun shouldBeGarbage(stack: List<Char>) = (stack.isNotEmpty() && stack.last() == '<')

    fun computeGarbageCharacters(input: String):Int {
        var sum = 0
        var cursor = 0
        var isGarbage = false

        while (cursor < input.length) {
            val char = input.get(cursor)

            if (char == '<') {
                if (isGarbage) {
                    sum++
                } else {
                    isGarbage = true
                }
            } else if (char == '!') {
                cursor++
            } else if (char == '>') {
                isGarbage = false
            } else if (isGarbage) {
                sum++
            }

            cursor++
        }

        return sum
    }
}

fun main(args: Array<String>) {
    val stream = File("src/main/resources/day_9/stream.txt").readText()

    println(StreamProcessing().computeSumOfNestedBlocks(stream))
    println(StreamProcessing().computeGarbageCharacters(stream))
}