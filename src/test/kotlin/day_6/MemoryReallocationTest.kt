package day_6

import org.junit.Test
import kotlin.test.assertEquals

class MemoryReallocationTest {

    @Test
    fun `given 4 blocks of memory then partOne should compute the correct number of steps after which the memory blocks come in the initial state`() {
        assertEquals (5, MemoryReallocation().partOne(listOf(0, 2, 7, 0)))
    }

    @Test
    fun `starting from a state that has already been seen partTwo should compute how many cycles must be performed before that same state is seen again`() {
        assertEquals (4, MemoryReallocation().partTwo(listOf(0, 2, 7, 0)))
    }
}