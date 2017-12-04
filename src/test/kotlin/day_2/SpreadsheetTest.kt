package day_2

import org.junit.Test
import kotlin.test.assertEquals

class SpreadsheetTest {

    @Test
    fun `checksum using max-min difference for given spreadsheet should be correct`() {
        val spreadsheet = Spreadsheet()
        val input = spreadsheet.readSpreadsheet("src/test/resources/day_2/spreadsheet_1.txt")

        val checksum = spreadsheet.computeChecksumUsingMaxMinDifferenceOfElements(input)

        assertEquals(18, checksum)
    }

    @Test
    fun `checksum using evenly division for given spreadsheet should be correct`() {
        val spreadsheet = Spreadsheet()
        val input = spreadsheet.readSpreadsheet("src/test/resources/day_2/spreadsheet_2.txt")

        val checksum = spreadsheet.computeChecksumUsingEvenlyDivisionOfElements(input)

        assertEquals(9, checksum)
    }

}