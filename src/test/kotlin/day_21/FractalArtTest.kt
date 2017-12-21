package day_21

import org.junit.Test
import kotlin.test.assertEquals

class FractalArtTest {

    @Test
    fun `given input image and rules when partOne is applied with 2 iterations then correct number of # pixels is returned`() {
        val input = listOf(listOf(".", "#", "."), listOf(".", ".", "#"), listOf("#", "#", "#"))
        val rules = FractalArt().readFile("src/test/resources/day_21/rules.txt")
        val iterations = 2

        assertEquals(12, FractalArt().partOne(rules, input, iterations))
    }
}