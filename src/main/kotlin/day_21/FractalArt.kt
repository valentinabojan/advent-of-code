package day_21

import java.io.File

class FractalArt {

    private val ON = '#'

    fun partOne(rules: Map<Array<CharArray>, Array<CharArray>>, input: Array<CharArray>, iterations: Int): Int {
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

        return image.sumBy { it.count { it == ON } }
    }

    private fun splitImage(image: Array<CharArray>, dividerFactor: Int): List<Array<CharArray>> {
        val smallImages = mutableListOf<Array<CharArray>>()

        for (i in 0 until image.size step dividerFactor) {
            for (j in 0 until image.size step dividerFactor) {
                val smallImage = Array(dividerFactor, { CharArray(dividerFactor) })

                for (r in 0 until dividerFactor) {
                    for (c in 0 until dividerFactor) {
                        smallImage[r][c] = image[i + r][j + c]
                    }
                }

                smallImages.add(smallImage)
            }
        }

        return smallImages
    }

    private fun applyRule(images: List<Array<CharArray>>, rules: Map<Array<CharArray>, Array<CharArray>>): List<Array<CharArray>> {
        return images.map { image ->
            for (rule in rules) {
                if (checkRule(rule.key, image)) {
                    return@map rule.value
                }
            }
            return@map image
        }
    }

    private fun countONPixels(image: Array<CharArray>) = image.contentDeepToString().count { it == ON }

    private fun combineImages(images: List<Array<CharArray>>, imageSize: Int, divideFactor: Int): Array<CharArray> {
        val newImage = mutableListOf<MutableList<Char>>()

        for (i in 0 until images.size) {
            val row = i / (imageSize / divideFactor)

            if (i % (imageSize / divideFactor) == 0) {
                images[i].forEach{ newImage.add(it.toMutableList())}
            } else {
                for (j in 0 until divideFactor + 1) {
                    newImage[(divideFactor + 1) * row + j].addAll(images[i][j].asList())
                }
            }
        }

        return newImage.map { it.toCharArray() }.toTypedArray()
    }

    private fun checkRule(rule: Array<CharArray>, input: Array<CharArray>): Boolean {
        val transformations = ImageTransformations()

//        if (rule.size != input.size) {
//            return false
//        }
//
//        if (countONPixels(rule) != countONPixels(input)) {
//            return false
//        }

        return rule.contentDeepEquals(input) ||
                rule.contentDeepEquals(transformations.flipVertically(input)) ||
                rule.contentDeepEquals(transformations.flipHorizontally(input)) ||
                rule.contentDeepEquals(transformations.flipByFirstDiagonal(input)) ||
                rule.contentDeepEquals(transformations.flipBySecondDiagonal(input)) ||
                rule.contentDeepEquals(transformations.rotate(input)) ||
                rule.contentDeepEquals(transformations.rotateClockWise(input))
    }

    fun readFile(path: String): Map<Array<CharArray>, Array<CharArray>> {
        val rules = mutableMapOf<Array<CharArray>, Array<CharArray>>()
        File(path).forEachLine {
            val elements = it.split(" => ")
            val pattern = elements[0].split("/").map { it.toCharArray() }.toTypedArray()
            val result = elements[1].split("/").map { it.toCharArray() }.toTypedArray()
            rules.put(pattern, result)
        }
        return rules
    }
}

fun main(args: Array<String>) {
    val rules = FractalArt().readFile("src/main/resources/day_21/rules.txt")
    val input = arrayOf(charArrayOf('.', '#', '.'), charArrayOf('.', '.', '#'), charArrayOf('#', '#', '#'))

    println(FractalArt().partOne(rules, input, 5))          // 152

    val s = System.currentTimeMillis()
    println(FractalArt().partOne(rules, input, 18))         // 1956174
    val e = System.currentTimeMillis()
    println(e - s)
}