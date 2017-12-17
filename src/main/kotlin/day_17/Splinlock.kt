package day_17

class Spinlock {

    fun partOne(steps: Int): Int {
        val buffer = mutableListOf(0)
        var currentPosition = 0

        for (i in 1 until 2018) {
            currentPosition = (currentPosition + steps) % buffer.size + 1
            buffer.add(currentPosition, i)
        }

        return buffer.get(currentPosition + 1)
    }

    fun partTwo(steps: Int, iterations: Int): Int {
        var valueAfter0 = -1
        var currentPosition = 0
        var bufferSize = 1

        for (i in 1 until iterations) {
            currentPosition = (currentPosition + steps) % bufferSize + 1
            if (currentPosition == 1) {
                valueAfter0 = i
            }
            bufferSize++
        }

        return valueAfter0
    }
}

fun main(args: Array<String>) {
    println(Spinlock().partOne(328))
    println(Spinlock().partTwo(328, 50_000_000))
}