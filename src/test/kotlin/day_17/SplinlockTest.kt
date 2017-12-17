package day_17

import org.junit.Test
import kotlin.test.assertEquals

class SplinlockTest {

    @Test
    fun `given 3 steps then executing 2017 iterations and getting the first value after 2017 should be correct`() {
        assertEquals (638, Spinlock().partOne(3))
    }

    @Test
    fun `given 3 steps then executing 2017 iterations and getting the first value after 0 should be correct`() {
        assertEquals (1226, Spinlock().partTwo(3, 2017))
    }
}