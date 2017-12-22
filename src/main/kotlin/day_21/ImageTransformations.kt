package day_21

class ImageTransformations {

    fun flipVertically(pattern: List<List<String>>): List<List<String>> {
        return pattern.reversed()
    }

    fun flipHorizontally(pattern: List<List<String>>): List<List<String>> {
        return pattern.map { it.reversed() }
    }

    fun flipByFirstDiagonal(pattern: List<List<String>>): List<List<String>> {
        return rotate(flipHorizontally(pattern))
    }

    fun flipBySecondDiagonal(pattern: List<List<String>>): List<List<String>> {
        return rotate(flipVertically(pattern))
    }

    fun rotate(pattern: List<List<String>>): List<List<String>> {
        val result = pattern.toMutableList().map { it.toMutableList() }

        for (i in 0 until pattern.size) {
            for (j in 0 until pattern.size) {
                result[i][j] = pattern[j][pattern.size - 1 - i]
            }
        }

        return result
    }

    fun rotateClockWise(pattern: List<List<String>>): List<List<String>> {
        val result = pattern.toMutableList().map { it.toMutableList() }

        for (i in 0 until pattern.size) {
            for (j in 0 until pattern.size) {
                result[i][j] = pattern[pattern.size - 1 - j][i]
            }
        }

        return result
    }
}