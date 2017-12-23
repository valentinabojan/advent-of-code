package day_22

class DirectionComputer {

    fun moveLeft(direction: String, x: Int, y: Int): Triple<String, Int, Int> {
        return when (direction) {
            "left" -> {
                Triple("down", x + 1, y)
            }
            "right" -> {
                Triple("up", x - 1, y)
            }
            "down" -> {
                Triple("right", x, y + 1)
            }
            else -> {
                Triple("left", x, y - 1)
            }
        }
    }

    fun moveRight(direction: String, x: Int, y: Int): Triple<String, Int, Int> {
        return when (direction) {
            "left" -> {
                Triple("up", x - 1, y)
            }
            "right" -> {
                Triple("down", x + 1, y)
            }
            "down" -> {
                Triple("left", x, y - 1)
            }
            else -> {
                Triple("right", x, y + 1)
            }
        }
    }

    fun moveForward(direction: String, x: Int, y: Int): Triple<String, Int, Int> {
        return when (direction) {
            "left" -> {
                Triple(direction, x, y - 1)
            }
            "right" -> {
                Triple(direction, x, y + 1)
            }
            "down" -> {
                Triple(direction, x + 1, y)
            }
            else -> {
                Triple(direction, x - 1, y)
            }
        }
    }

    fun moveBackward(direction: String, x: Int, y: Int): Triple<String, Int, Int> {
        return when (direction) {
            "left" -> {
                Triple("right", x, y + 1)
            }
            "right" -> {
                Triple("left", x, y - 1)
            }
            "down" -> {
                Triple("up", x - 1, y)
            }
            else -> {
                Triple("down", x + 1, y)
            }
        }
    }
}