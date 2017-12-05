package day_4

import org.junit.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class PasswordTest {

    @Test
    fun `given check using duplicate words 'aa bb cc dd ee' password should be valid`() {
        val isPasswordValid = Password().isValidUsingDuplicateWords("aa bb cc dd ee")

        assertTrue (isPasswordValid)
    }

    @Test
    fun `given check using duplicate words 'aa bb cc dd aa' password should not be invalid`() {
        val isPasswordValid = Password().isValidUsingDuplicateWords("aa bb cc dd aa")

        assertFalse (isPasswordValid)
    }

    @Test
    fun `given check using duplicate words 'aa bb cc dd aaa' password should be valid`() {
        val isPasswordValid = Password().isValidUsingDuplicateWords("aa bb cc dd aaa")

        assertTrue (isPasswordValid)
    }

    @Test
    fun `given check using anagram words 'abcde fghij' password should be valid`() {
        val isPasswordValid = Password().isValidUsingAnagramWords("abcde fghij")

        assertTrue (isPasswordValid)
    }

    @Test
    fun `given check using anagram words 'abcde xyz ecdab' password should be invalid`() {
        val isPasswordValid = Password().isValidUsingAnagramWords("abcde xyz ecdab")

        assertFalse (isPasswordValid)
    }

    @Test
    fun `given check using anagram words 'a ab abc abd abf abj' password should be valid`() {
        val isPasswordValid = Password().isValidUsingAnagramWords("a ab abc abd abf abj")

        assertTrue (isPasswordValid)
    }

    @Test
    fun `given check using anagram words 'iiii oiii ooii oooi oooo' password should be valid`() {
        val isPasswordValid = Password().isValidUsingAnagramWords("iiii oiii ooii oooi oooo")

        assertTrue (isPasswordValid)
    }

    @Test
    fun `given check using anagram words 'oiii ioii iioi iiio' password should be invalid`() {
        val isPasswordValid = Password().isValidUsingAnagramWords("oiii ioii iioi iiio")

        assertFalse (isPasswordValid)
    }

}