package day_21

import java.io.File

class FractalArt {

    private val ON = "#"

    fun partOne(rules: Map<List<List<String>>, List<List<String>>>, input: List<List<String>>, iterations: Int): Int {
        var image = input

        for (i in 0 until iterations) {
            if (image.size % 2 == 0) {
                val smallImages = splitImage(image, 2).toMutableList()
                val updatedSmallImages = applyRule(smallImages, rules)
                image = combineImages(updatedSmallImages, image.size, 2)

            } else if (image.size % 3 == 0) {
                val smallImages = splitImage(image, 3).toMutableList()
                val updatedSmallImages = applyRule(smallImages, rules)
                image = combineImages(updatedSmallImages, image.size, 3)
            }
        }

        return image.flatMap { it }.count { it == ON }
    }

    private fun splitImage(image: List<List<String>>, dividerFactor: Int): List<List<List<String>>> {
        val smallImages = mutableListOf<List<List<String>>>()

        for (i in 0 until image.size step dividerFactor) {
            for (j in 0 until image.size step dividerFactor) {
                val smallImage = List(dividerFactor) { arrayOfNulls<String>(dividerFactor) }

                for (r in 0 until dividerFactor) {
                    for (c in 0 until dividerFactor) {
                        smallImage[r][c] = image[i + r][j + c]
                    }
                }

                smallImages.add(smallImage.map { it.toList().requireNoNulls().toList() })
            }
        }

        return smallImages
    }

    private fun applyRule(images: List<List<List<String>>>, rules: Map<List<List<String>>, List<List<String>>>): List<List<List<String>>> {
        return images.map { image ->
            for (rule in rules) {
                if (checkRule(rule.key, image)) {
                    return@map rule.value
                }
            }
            return@map image
        }
    }

    private fun combineImages(images: List<List<List<String>>>, imageSize: Int, divideFactor: Int): List<List<String>> {
        val newImage = mutableListOf<MutableList<String>>()

        for (i in 0 until images.size) {
            val row = i / (imageSize / divideFactor)

            if (i % (imageSize / divideFactor) == 0) {
                images[i].forEach{ newImage.add(it.toMutableList())}
            } else {
                for (j in 0 until divideFactor + 1) {
                    newImage[(divideFactor + 1) * row + j].addAll(images[i][j])
                }
            }
        }

        return newImage
    }

    private fun checkRule(rule: List<List<String>>, input: List<List<String>>): Boolean {
        val transformations = ImageTransformations()

        val flipCheck =
                rule == transformations.flipVertically(input) ||
                rule == transformations.flipHorizontally(input) ||
                rule == transformations.flipByFirstDiagonal(input) ||
                rule == transformations.flipBySecondDiagonal(input)

        var rotateCheck = false
        var rotateInput = input
        for (i in 0 until 4) {
            rotateInput = transformations.rotate(rotateInput)
            if (rule == rotateInput) {
                rotateCheck = true
                break
            }
        }

        return flipCheck || rotateCheck
    }

    fun readFile(path: String): Map<List<List<String>>, List<List<String>>> {
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

    println(FractalArt().partOne(rules, input, 5))          // 152
    println(FractalArt().partOne(rules, input, 18))         // 1956174
}