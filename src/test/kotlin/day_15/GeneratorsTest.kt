package day_15

import org.junit.Test
import kotlin.test.assertEquals

class GeneratorsTest {

    @Test
    fun `given generators first values computing count for judge using all values from generators should be correct`() {
        assertEquals (588, Generators().partOne(65, 8921))
    }

    @Test
    fun `given generators first values computing count for judge using only certain values from generators should be correct`() {
        assertEquals (309, Generators().partTwo(65, 8921))
    }

}