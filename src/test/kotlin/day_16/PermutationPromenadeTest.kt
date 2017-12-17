package day_16

import org.junit.Test
import kotlin.test.assertEquals

class PermutationPromenadeTest {

    @Test
    fun `given 5 programs and 3 moves then the correct final programs order should be determined`() {
        assertEquals ("baedc", PermutationPromenade().partOne("abcde", listOf("s1", "x3/4", "pe/b")))
    }

    @Test
    fun `given 5 programs and 3 moves then the correct final programs order should be determined after 1_000_000_000 iterations`() {
        assertEquals ("abcde", PermutationPromenade().partTwo("abcde", listOf("s1", "x3/4", "pe/b")))
    }

}