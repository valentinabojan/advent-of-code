package day_20

import java.io.File

class ParticleSwarm {

    fun partOne(positions: List<Triple<Int, Int, Int>>, accelerations: List<Triple<Int, Int, Int>>, velocities: List<Triple<Int, Int, Int>>): Int {
        var iteration = 1
        var closestParticle = positions.size + 1
        var closestParticleStability = 0

        while (true) {
            val distances = mutableListOf<Int>()
            val newPositions = mutableListOf<Triple<Int, Int, Int>>()

            for (i in 0 until positions.size) {
                val newX = positions[i].first + iteration * velocities[i].first + sum(iteration) * accelerations[i].first
                val newY = positions[i].second + iteration * velocities[i].second + sum(iteration) * accelerations[i].second
                val newZ = positions[i].third + iteration * velocities[i].third + sum(iteration) * accelerations[i].third
                newPositions.add(Triple(newX, newY, newZ))

                distances.add(Math.abs(newX - 0) + Math.abs(newY - 0) + Math.abs(newZ - 0))
            }

            val closestDistance = distances.min()
            if (distances.indexOf(closestDistance) != closestParticle) {
                closestParticle = distances.indexOf(closestDistance)
                closestParticleStability = 1
            } else {
                closestParticleStability++
            }

            if (closestParticleStability == 500) {
                return closestParticle
            }

            iteration++
        }
    }

    private fun sum(n: Int): Int {
        var sum = 0

        for (i in 0 until n + 1) {
            sum += i
        }

        return sum
    }

    fun partTwo(positions: List<Triple<Int, Int, Int>>, accelerations: List<Triple<Int, Int, Int>>, velocities: List<Triple<Int, Int, Int>>): Int {
        val newPositions = positions.toMutableList()
        var iteration = 1
        var collisionStability = 0

        while (true) {
            for (i in 0 until newPositions.size) {
                if (newPositions[i] == Triple( Int.MAX_VALUE, Int.MAX_VALUE, Int.MAX_VALUE)) {
                    continue
                }

                val newX = newPositions[i].first + velocities[i].first + iteration * accelerations[i].first
                val newY = newPositions[i].second + velocities[i].second + iteration * accelerations[i].second
                val newZ = newPositions[i].third + velocities[i].third + iteration * accelerations[i].second
                newPositions[i] = Triple(newX, newY, newZ)
            }

            val collidedParticles = newPositions
                    .groupBy { it }
                    .filter { it.value.size > 1 && it.key != Triple(Int.MAX_VALUE, Int.MAX_VALUE, Int.MAX_VALUE) }.keys

            for (i in 0 until newPositions.size) {
                if (collidedParticles.contains(newPositions[i])) {
                    newPositions[i] = Triple( Int.MAX_VALUE, Int.MAX_VALUE, Int.MAX_VALUE)
                }
            }

            println(collidedParticles.size)
            if (collidedParticles.isNotEmpty()) {
                collisionStability = 0
            } else {
                collisionStability++
            }

            if (collisionStability == 50000) {
                return newPositions.filter { it != Triple( Int.MAX_VALUE, Int.MAX_VALUE, Int.MAX_VALUE) }.size
            }

            iteration++
        }
    }


}

fun main(args: Array<String>) {
    val positions = mutableListOf<Triple<Int, Int, Int>>()
    val accelerations = mutableListOf<Triple<Int, Int, Int>>()
    val velocities = mutableListOf<Triple<Int, Int, Int>>()
    File("src/main/resources/day_20/moves_1.txt").forEachLine {
        val elements = it.split(", ")
        val position = elements[0].substring(3, elements[0].length - 1).split(",").map { it.toInt() }
        val velocity = elements[1].substring(3, elements[1].length - 1).split(",").map { it.toInt() }
        val acceleration = elements[2].substring(3, elements[2].length - 1).split(",").map { it.toInt() }

        positions.add(Triple(position[0], position[1], position[2]))
        accelerations.add(Triple(acceleration[0], acceleration[1], acceleration[2]))
        velocities.add(Triple(velocity[0], velocity[1], velocity[2]))
    }

    println(ParticleSwarm().partOne(positions, accelerations, velocities))
    println(ParticleSwarm().partTwo(positions, accelerations, velocities))
}