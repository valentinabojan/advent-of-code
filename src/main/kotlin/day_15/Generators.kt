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
        var count = 0
        var acceptedValuesByJudge = 0
        val generatedValuesByA = mutableListOf<Long>()
        val generatedValuesByB = mutableListOf<Long>()
var i = 0
        while (acceptedValuesByJudge <= 5_000_000) {
            generatorAValue = (generatorAValue * 16807) % 2147483647
            generatorBValue = (generatorBValue * 48271) % 2147483647

            if (generatorAValue % 4 == 0L) {
                generatedValuesByA.add(generatorAValue)
            }

            if (generatorBValue % 8 == 0L) {
                generatedValuesByB.add(generatorBValue)
            }
//
            if (generatedValuesByA.isNotEmpty() && generatedValuesByB.isNotEmpty()) {
                acceptedValuesByJudge++
                if (areLast16BitsEqual(generatedValuesByA.removeAt(0), generatedValuesByB.removeAt(0))) {
                    count++
                }
            }
             i++
        }

        return count
    }

    private fun areLast16BitsEqual(a: Long, b: Long) = a.toShort() == b.toShort()
}

fun main(args: Array<String>) {
    println(Generators().partOne(699, 124))
}