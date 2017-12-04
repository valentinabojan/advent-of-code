package day_1

import org.junit.Test
import kotlin.test.assertEquals

class CaptchaTest {

    @Test
    fun `captcha for 1122 and step=1 should return 3`() {
        val computedCaptcha = Captcha().computeCaptcha("1122", 1)

        assertEquals(3, computedCaptcha)
    }

    @Test
    fun `captcha for 11221 and step=1 should return 4`() {
        val computedCaptcha = Captcha().computeCaptcha("11221", 1)

        assertEquals(4, computedCaptcha)
    }

    @Test
    fun `captcha for 1111 and step=1 should return 4`() {
        val computedCaptcha = Captcha().computeCaptcha("1111", 1)

        assertEquals(4, computedCaptcha)
    }

    @Test
    fun `captcha for 1234 and step=1 should return 0`() {
        val computedCaptcha = Captcha().computeCaptcha("1234", 1)

        assertEquals(0, computedCaptcha)
    }

    @Test
    fun `captcha for 91212129 and step=1 should return 9`() {
        val computedCaptcha = Captcha().computeCaptcha("91212129", 1)

        assertEquals(9, computedCaptcha)
    }

    @Test
    fun `captcha for 9 and step=1 should return 0`() {
        val computedCaptcha = Captcha().computeCaptcha("9", 1)

        assertEquals(0, computedCaptcha)
    }

    @Test
    fun `captcha for 1212 and step=2 should return 6`() {
        val digits = "1212"
        val computedCaptcha = Captcha().computeCaptcha(digits, digits.length/2)

        assertEquals(6, computedCaptcha)
    }

    @Test
    fun `captcha for 1221 and step=2 should return 0`() {
        val digits = "1221"
        val computedCaptcha = Captcha().computeCaptcha(digits, digits.length/2)

        assertEquals(0, computedCaptcha)
    }

    @Test
    fun `captcha for 123425 and step=3 should return 4`() {
        val digits = "123425"
        val computedCaptcha = Captcha().computeCaptcha(digits, digits.length/2)

        assertEquals(4, computedCaptcha)
    }

    @Test
    fun `captcha for 123123 and step=3 should return 12`() {
        val digits = "123123"
        val computedCaptcha = Captcha().computeCaptcha(digits, digits.length/2)

        assertEquals(12, computedCaptcha)
    }

    @Test
    fun `captcha for 12131415 and step=4 should return 4`() {
        val digits = "12131415"
        val computedCaptcha = Captcha().computeCaptcha(digits, digits.length/2)

        assertEquals(4, computedCaptcha)
    }

}