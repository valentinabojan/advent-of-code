package day_20

import org.junit.Test
import kotlin.test.assertEquals

class ParticleSwarmTest {

    @Test
    fun `given set of partitions from example then partOne should compute the closest particle in the long term`() {
        val (positions, accelerations, velocities) = ParticleSwarm().readFile("src/test/resources/day_20/particles_1.txt")

        assertEquals(0, ParticleSwarm().partOne(positions, accelerations, velocities))
    }

    @Test
    fun `given set of partitions from unique input then partOne should compute the closest particle in the long term`() {
        val (positions, accelerations, velocities) = ParticleSwarm().readFile("src/test/resources/day_20/particles.txt")

        assertEquals(150, ParticleSwarm().partOne(positions, accelerations, velocities))
    }

    @Test
    fun `given set of partitions from example then partTwo should compute how many particles are left after all collisions were resolved`() {
        val (positions, accelerations, velocities) = ParticleSwarm().readFile("src/test/resources/day_20/particles_2.txt")

        assertEquals(1, ParticleSwarm().partTwo(positions, accelerations, velocities))
    }

    @Test
    fun `given set of partitions from unique input then partTwo should compute how many particles are left after all collisions were resolved`() {
        val (positions, accelerations, velocities) = ParticleSwarm().readFile("src/test/resources/day_20/particles.txt")

        assertEquals(657, ParticleSwarm().partTwo(positions, accelerations, velocities))
    }
}