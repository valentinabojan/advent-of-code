package day_4

import java.io.File

class Password {

    fun isValidUsingDuplicateWords(password: String): Boolean {
        return password.split(" ")
                .groupingBy { it }
                .eachCount()
                .filter { it -> it.value > 1 }
                .isEmpty()
    }

    fun isValidUsingAnagramWords(password: String): Boolean {
        return password.split(" ")
                .map { String(it.toCharArray().sortedArray()) }
                .groupingBy { it }
                .eachCount()
                .filter { it -> it.value > 1 }
                .isEmpty()
    }

}

fun main(args: Array<String>) {
    var validPasswordsUsingDuplicateWords = 0
    File("src/main/resources/day_4/passwords_1.txt")
            .forEachLine { line ->
                if (Password().isValidUsingDuplicateWords(line)) {
                    validPasswordsUsingDuplicateWords++
                }
            }
    println(validPasswordsUsingDuplicateWords)

    var validPasswordsUsingAnagrams = 0
    File("src/main/resources/day_4/passwords_2.txt")
            .forEachLine { line ->
                if (Password().isValidUsingAnagramWords(line)) {
                    validPasswordsUsingAnagrams++
                }
            }
    println(validPasswordsUsingAnagrams)
}