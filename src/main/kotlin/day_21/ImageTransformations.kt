package day_21

class ImageTransformations {

    fun flipVertically(pattern: Array<CharArray>): Array<CharArray> {
        return pattern.reversedArray()
    }

    fun flipHorizontally(pattern: Array<CharArray>): Array<CharArray> {
        return pattern.map { it.reversedArray() }.toTypedArray()
    }

    fun flipByFirstDiagonal(pattern: Array<CharArray>): Array<CharArray> {
        return rotate(flipHorizontally(pattern))
    }

    fun flipBySecondDiagonal(pattern: Array<CharArray>): Array<CharArray> {
        return rotate(flipVertically(pattern))
    }

    fun rotate(pattern: Array<CharArray>): Array<CharArray> {
        val result = Array(pattern.size, {CharArray(pattern.size)})

        for (i in 0 until pattern.size) {
            for (j in 0 until pattern.size) {
                result[i][j] = pattern[j][pattern.size - 1 - i]
            }
        }

        return result
    }

    fun rotateClockWise(pattern: Array<CharArray>): Array<CharArray> {
        val result = Array(pattern.size, {CharArray(pattern.size)})

        for (i in 0 until pattern.size) {
            for (j in 0 until pattern.size) {
                result[i][j] = pattern[pattern.size - 1 - j][i]
            }
        }

        return result
    }
}