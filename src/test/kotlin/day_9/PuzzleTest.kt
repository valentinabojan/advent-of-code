package day_9

import org.junit.Test
import kotlin.test.assertEquals

class PuzzleTest {

    @Test
    fun `given different puzzles computeSumOfNestedBlocks should return correct sums`() {
        assertEquals (1, Puzzle().computeSumOfNestedBlocks("{}"))
        assertEquals (6, Puzzle().computeSumOfNestedBlocks("{{{}}}"))
        assertEquals (5, Puzzle().computeSumOfNestedBlocks("{{},{}}"))
        assertEquals (16, Puzzle().computeSumOfNestedBlocks("{{{},{},{{}}}}"))
        assertEquals (1, Puzzle().computeSumOfNestedBlocks("{<a>,<a>,<a>,<a>}"))
        assertEquals (9, Puzzle().computeSumOfNestedBlocks("{{<ab>},{<ab>},{<ab>},{<ab>}}"))
        assertEquals (9, Puzzle().computeSumOfNestedBlocks("{{<!!>},{<!!>},{<!!>},{<!!>}}"))
        assertEquals (3, Puzzle().computeSumOfNestedBlocks("{{<a!>},{<a!>},{<a!>},{<ab>}}"))
    }

    @Test
    fun `given different puzzles computeGarbageCharacters should return correct sums`() {
        assertEquals (0, Puzzle().computeGarbageCharacters("<>"))
        assertEquals (17, Puzzle().computeGarbageCharacters("<random characters>"))
        assertEquals (3, Puzzle().computeGarbageCharacters("<<<<>"))
        assertEquals (2, Puzzle().computeGarbageCharacters("<{!>}>"))
        assertEquals (0, Puzzle().computeGarbageCharacters("<!!>"))
        assertEquals (0, Puzzle().computeGarbageCharacters("<!!!>>"))
        assertEquals (10, Puzzle().computeGarbageCharacters("<{o\"i!a,<{i<a>"))
    }
}