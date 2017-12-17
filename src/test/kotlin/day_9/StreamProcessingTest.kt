package day_9

import org.junit.Test
import kotlin.test.assertEquals

class StreamProcessingTest {

    @Test
    fun `given different streams computeSumOfNestedBlocks should return correct sums`() {
        assertEquals (1, StreamProcessing().computeSumOfNestedBlocks("{}"))
        assertEquals (6, StreamProcessing().computeSumOfNestedBlocks("{{{}}}"))
        assertEquals (5, StreamProcessing().computeSumOfNestedBlocks("{{},{}}"))
        assertEquals (16, StreamProcessing().computeSumOfNestedBlocks("{{{},{},{{}}}}"))
        assertEquals (1, StreamProcessing().computeSumOfNestedBlocks("{<a>,<a>,<a>,<a>}"))
        assertEquals (9, StreamProcessing().computeSumOfNestedBlocks("{{<ab>},{<ab>},{<ab>},{<ab>}}"))
        assertEquals (9, StreamProcessing().computeSumOfNestedBlocks("{{<!!>},{<!!>},{<!!>},{<!!>}}"))
        assertEquals (3, StreamProcessing().computeSumOfNestedBlocks("{{<a!>},{<a!>},{<a!>},{<ab>}}"))
    }

    @Test
    fun `given different streams computeGarbageCharacters should return correct sums`() {
        assertEquals (0, StreamProcessing().computeGarbageCharacters("<>"))
        assertEquals (17, StreamProcessing().computeGarbageCharacters("<random characters>"))
        assertEquals (3, StreamProcessing().computeGarbageCharacters("<<<<>"))
        assertEquals (2, StreamProcessing().computeGarbageCharacters("<{!>}>"))
        assertEquals (0, StreamProcessing().computeGarbageCharacters("<!!>"))
        assertEquals (0, StreamProcessing().computeGarbageCharacters("<!!!>>"))
        assertEquals (10, StreamProcessing().computeGarbageCharacters("<{o\"i!a,<{i<a>"))
    }
}