package day_15

class Generators {

    fun partOne(generatorAStartValue: Long, generatorBStartValue: Long): Int {
        var generatorAValue = generatorAStartValue
        var generatorBValue = generatorBStartValue
        var count = 0

        for (i in 0 until 40_000_000) {
            generatorAValue = (generatorAValue * 16807) % 2147483647
            generatorBValue = (generatorBValue * 48271) % 2147483647

            if (areLast16BitsEqual(generatorAValue, generatorBValue)) {
                count++
            }
        }

        return count
    }

    fun partTwo(generatorAStartValue: Long, generatorBStartValue: Long): Int {
        var generatorAValue = generatorAStartValue
        var generatorBValue = generatorBStartValue
        val generatedValuesByA = mutableListOf<Long>()
        val generatedValuesByB = mutableListOf<Long>()

        while (generatedValuesByA.size < 5_000_000) {
            generatorAValue = (generatorAValue * 16807) % 2147483647
            if (generatorAValue % 4 == 0L) {
                generatedValuesByA.add(generatorAValue)
            }
        }

        while (generatedValuesByB.size < 5_000_000) {
            generatorBValue = (generatorBValue * 48271) % 2147483647
            if (generatorBValue % 8 == 0L) {
                generatedValuesByB.add(generatorBValue)
            }
        }

        return (0 until 5_000_000).count { areLast16BitsEqual(generatedValuesByA[it], generatedValuesByB[it]) }
    }

    private fun areLast16BitsEqual(a: Long, b: Long) = a.toShort() == b.toShort()
}

fun main(args: Array<String>) {
    println(Generators().partOne(699, 124))
    println(Generators().partTwo(699, 124))
}