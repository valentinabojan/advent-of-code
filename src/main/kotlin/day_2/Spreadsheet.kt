package day_2

import java.io.File
import java.util.*

class Spreadsheet {

    fun readSpreadsheet(path: String): List<List<Int>> {
        val spreadsheet = mutableListOf<List<Int>>()

        File(path)
                .forEachLine { line ->
                    spreadsheet.add(
                            line
                                    .split("\t")
                                    .toList()
                                    .map { i -> i.toInt() }
                                    .toList()
                    )
                }

        return spreadsheet
    }

    fun computeChecksumUsingMaxMinDifferenceOfElements(spreadsheet: List<List<Int>>): Int {
        return spreadsheet
                .map { list -> listOf(list.min(), list.max()) }
                .flatMap { list -> listOf(list[1]!!.minus(list[0]!!)) }
                .sum()
    }

    fun computeChecksumUsingEvenlyDivisionOfElements(spreadsheet: List<List<Int>>): Int {
       return spreadsheet
            .map { line ->
                val sortedLine = line.sorted()
                for (i in 0 until sortedLine.size) {
                    for (j in i + 1 until sortedLine.size) {
                        if (sortedLine[j] % sortedLine[i] == 0) {
                            return@map listOf(sortedLine[j] / sortedLine[i])
                        }
                    }
                }
                return@map listOf<Int>()
            }
            .flatMap { it }
            .sum()
    }
}

fun main(args: Array<String>) {
    val spreadsheet = Spreadsheet()
    val input1 = spreadsheet.readSpreadsheet("src/main/resources/day_2/spreadsheet_1.txt")
    val input2 = spreadsheet.readSpreadsheet("src/main/resources/day_2/spreadsheet_2.txt")

    println(spreadsheet.computeChecksumUsingMaxMinDifferenceOfElements(input1))
    println(spreadsheet.computeChecksumUsingEvenlyDivisionOfElements(input2))
}