package day_5

import org.junit.Test
import kotlin.test.assertEquals

class MazeTest {

    @Test
    fun `given maze computeIncrementalSteps simple number of steps using should be correct`() {
        val steps = Maze().computeIncrementalSteps("0 3 0 1 -3")

        assertEquals (5, steps)
    }

    @Test
    fun `given maze computeIncrementalDecrementalSteps simple number of steps using should be correct`() {
        val steps = Maze().computeIncrementalDecrementalSteps("0 3 0 1 -3")

        assertEquals (10, steps)
    }
}