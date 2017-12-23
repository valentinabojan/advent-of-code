package day_22

import org.junit.Test
import kotlin.test.assertEquals

class SporificaVirusTest {

    @Test
    fun `given input map when partOne is applied with different iterations then correct number of infected cells is returned`() {
        val map = SporificaVirus().readFile("src/test/resources/day_22/map.txt")

        assertEquals(5, SporificaVirus().partOne(map, 7))
        assertEquals(41, SporificaVirus().partOne(map, 70))
        assertEquals(5587, SporificaVirus().partOne(map, 10_000))
    }

    @Test
    fun `given input map when partTwo is applied with different iterations then correct number of infected cells is returned`() {
        val map = SporificaVirus().readFile("src/test/resources/day_22/map.txt")

        assertEquals(26, SporificaVirus().partTwo(map, 100))
        assertEquals(2511944, SporificaVirus().partTwo(map, 10_000_000))
    }
}