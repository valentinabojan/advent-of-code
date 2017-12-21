package day_21

import java.io.File

class FractalArt {

    private val ON = "#"
    private val OFF = "."

    fun partOne(rules: MutableMap<List<List<String>>, List<List<String>>>, input: List<List<String>>, iterations: Int): Int {
        var image = input.toMutableList()

        for (i in 0 until iterations) {
            val smallImages = mutableListOf<List<List<String>>>()

            if (image.size % 2 == 0) {
                for (y in 0 until image.size step 2) {
                    for (x in 0 until image.size step 2) {
                        val smallImage = List(2) { arrayOfNulls<String>(2) }

                        smallImage[0][0] = image[y][x]
                        smallImage[0][1] = image[y][x + 1]
                        smallImage[1][0] = image[y + 1][x]
                        smallImage[1][1] = image[y + 1][x + 1]

                        for (rule in rules) {
                            if (checkRule(rule.key, smallImage.map { it.toList().requireNoNulls() })) {
                                smallImages.add(rule.value)
                                break
                            }
                        }
                    }
                }

                val newImage = mutableListOf<MutableList<String>>()
                for (s in 0 until smallImages.size) {
                    val row = s/2

                    if (s%2 == 0) {
                        smallImages[s].forEach{ newImage.add(it.toMutableList())}
                    } else {
                        for (si in 0 until 3) {
                            newImage[3 * row + si].addAll(smallImages[s][si])
                        }
                    }
                }

                image = newImage.toMutableList()

            } else if (image.size % 3 == 0) {
                for (y in 0 until image.size step 3) {
                    for (x in 0 until image.size step 3) {
                        val smallImage = List(3) { arrayOfNulls<String>(3) }

                        smallImage[0][0] = image[y][x]
                        smallImage[0][1] = image[y][x + 1]
                        smallImage[0][2] = image[y][x + 2]
                        smallImage[1][0] = image[y + 1][x]
                        smallImage[1][1] = image[y + 1][x + 1]
                        smallImage[1][2] = image[y + 1][x + 2]
                        smallImage[2][0] = image[y + 2][x]
                        smallImage[2][1] = image[y + 2][x + 1]
                        smallImage[2][2] = image[y + 2][x + 2]

                        for (rule in rules) {
                            if (checkRule(rule.key, smallImage.map { it.toList().requireNoNulls() })) {
                                smallImages.add(rule.value)
                                break
                            }
                        }
                    }
                }

                val newImage = mutableListOf<MutableList<String>>()
                for (s in 0 until smallImages.size) {
                    val row = s/3

                    if (s%3 == 0) {
                        smallImages[s].forEach{ newImage.add(it.toMutableList())}
                    } else {
                        for (si in 0 until 4) {
                            newImage[4 * row + si].addAll(smallImages[s][si])
                        }
                    }
                }

                image = newImage.toMutableList()
            }

            println()
        }

        var count = 0

        image.forEach { it.forEach { if(it == ON) count++ } }


        return count
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
    val rules = FractalArt().readFile("src/main/resources/day_21/rules_1.txt")
    val input = listOf(listOf(".", "#", "."), listOf(".", ".", "#"), listOf("#", "#", "#"))
    val iterations = 2

    println(FractalArt().partOne(rules, input, iterations))
//    println(ParticleSwarm().partTwo(positions, accelerations, velocities))
}
