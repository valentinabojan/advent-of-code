package day_19

import java.io.File

class Duet {

    fun partOne(input: List<List<Char>>): Pair<String, Int> {
        var x = 0
        var y = input.get(0).indexOf('|')
        var direction = "down"

        var counter = 0
        var stringBuffer = ""

        while (true) {
            if (Character.isLetter(input.get(x).get(y))) {
                stringBuffer += input.get(x).get(y)
            }

            if (direction == "down") {
                if (input.get(x).get(y) == '+') {
                    if ((x + 1) < input.size && input.get(x + 1).get(y) != ' ') {
                        x++
                    } else if ((y + 1) < input.get(x).size && input.get(x).get(y + 1) != ' ') {
                        y++
                        direction = "right"
                    } else if ((y - 1) >= 0 && input.get(x).get(y - 1) != ' ') {
                        y--
                        direction = "left"
                    }
                } else {
                    x++
                }
            } else if (direction == "up") {
                if (input.get(x).get(y) == '+') {
                    if ((x - 1) >= 0 && input.get(x - 1).get(y) != ' ') {
                        x--
                    } else if ((y + 1) < input.get(x).size && input.get(x).get(y + 1) != ' ') {
                        y++
                        direction = "right"
                    } else if ((y - 1) >= 0 && input.get(x).get(y - 1) != ' ') {
                        y--
                        direction = "left"
                    }
                } else {
                    x--
                }
            } else if (direction == "right") {
                if (input.get(x).get(y) == '+') {
                    if ((y + 1) < input.get(x).size && input.get(x).get(y + 1) != ' ') {
                        y++
                    } else if ((x - 1) >= 0 && input.get(x - 1).get(y) != ' ') {
                        x--
                        direction = "up"
                    } else if ((x + 1) < input.size && input.get(x + 1).get(y) != ' ') {
                        x++
                        direction = "down"
                    }
                } else {
                    y++
                }
            } else if (direction == "left") {
                if (input.get(x).get(y) == '+') {
                    if ((y - 1) >= 0 && input.get(x).get(y - 1) != ' ') {
                        y--
                    } else if ((x - 1) >= 0 && input.get(x - 1).get(y) != ' ') {
                        x--
                        direction = "up"
                    } else if ((x + 1) < input.size && input.get(x + 1).get(y) != ' ') {
                        x++
                        direction = "down"
                    }
                } else {
                    y--
                }
            }

            counter++

            if (x < 0 || y < 0 || x >= input.size || y >= input.get(x).size || input.get(x).get(y) == ' ') {
                break
            }
        }

        return Pair(stringBuffer, counter)
    }


}

fun main(args: Array<String>) {
//    val moves = File("src/main/resources/day_18/moves.txt").readText().split("\n").toList()
    var list = mutableListOf<List<Char>>()
    File("src/main/resources/day_19/moves_1.txt").forEachLine { list.add(it.toCharArray().asList()) }

    println(Duet().partOne(list))
//    println(PermutationPromenade().partTwo("abcdefghijklmnop", moves))
}