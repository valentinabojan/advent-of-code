package day_21

import java.io.File

class FractalArt {

    private val ON = "#"
    private val OFF = "."

    fun partOne(rules: MutableMap<List<List<String>>, List<List<String>>>, input: List<List<String>>, iterations: Int): Int {
        val image = input.toMutableList()

        for (i in 0 until iterations) {
            if (image.size % 2 == 0) {
                val smallImages = mutableListOf<List<List<String>>>()

                for (y in 0 until image.size step 2) {
                    for (x in 0 until image.size step 2) {
                        val smallImage = mutableListOf<MutableList<String>>()

                        smallImage[0][0] = image[y][x]
                        smallImage[0][1] = image[y][x + 1]
                        smallImage[1][0] = image[y + 1][x]
                        smallImage[1][1] = image[y + 1][x + 1]

                        smallImages.add(smallImage)
                    }
                }







            }


        }




        return 0
    }

    private fun checkRule(rule: List<List<String>>, input: List<List<String>>): Boolean {
        if (input == flipVertically(rule)) {
            return true
        }

        if (input == flipHorizontally(rule)) {
            return true
        }

        var rotateRule = rule
        for (i in 0 until 4) {
            rotateRule = rotate(rotateRule)
            if (input == rotateRule) {
                return true
            }
        }

        return false
    }

    private fun flipVertically(rule: List<List<String>>): List<List<String>> {
        return rule.reversed()
    }

    private fun flipHorizontally(rule: List<List<String>>): List<List<String>> {
        return rule.map { it.reversed() }
    }

    private fun rotate(rule: List<List<String>>): List<List<String>> {
        val result = List(rule.size) { arrayOfNulls<String>(rule.size) }

        for (r in 0 until rule.size) {
            val column = rule[r].reversed()

            for (c in 0 until rule.size) {
                result[c][r] = column[c]
            }
        }

        return result.map { it.toList().requireNoNulls() }
    }

    fun readFile(path: String): MutableMap<List<List<String>>, List<List<String>>> {
        val rules = mutableMapOf<List<List<String>>, List<List<String>>>()
        File(path).forEachLine {
            val elements = it.split(" => ")
            val pattern = elements[0].split("/").map { it.toCharArray().map { it + "" }.toList() }
            val result = elements[1].split("/").map { it.toCharArray().map { it + "" }.toList() }
            rules.put(pattern, result)

        }
        return rules
    }
}

fun main(args: Array<String>) {
    val rules = FractalArt().readFile("src/main/resources/day_21/rules.txt")
    val input = listOf(listOf(".", "#", "."), listOf(".", ".", "#"), listOf("#", "#", "#"))
    val iterations = 5

    println(FractalArt().partOne(rules, input, iterations))
//    println(ParticleSwarm().partTwo(positions, accelerations, velocities))
}
