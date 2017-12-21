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
        val result = List(pattern.size) { arrayOfNulls<String>(pattern.size) }

        for (r in 0 until pattern.size) {
            val column = pattern[r].reversed()
            for (c in 0 until pattern.size) {
                result[c][r] = column[c]
            }
        }

        return result.map { it.toList().requireNoNulls() }
    }
}