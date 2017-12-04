package day_1

import org.junit.Test
import kotlin.test.assertEquals

class CaptchaTest {

    @Test
    fun `captcha for 1122 should return 3`() {
        val computedCaptcha = Captcha().computeCaptcha("1122")

        assertEquals(3, computedCaptcha)
    }

    @Test
    fun `captcha for 11221 should return 4`() {
        val computedCaptcha = Captcha().computeCaptcha("11221")

        assertEquals(4, computedCaptcha)
    }

    @Test
    fun `captcha for 1111 should return 4`() {
        val computedCaptcha = Captcha().computeCaptcha("1111")

        assertEquals(4, computedCaptcha)
    }

    @Test
    fun `captcha for 1234 should return 0`() {
        val computedCaptcha = Captcha().computeCaptcha("1234")

        assertEquals(0, computedCaptcha)
    }

    @Test
    fun `captcha for 91212129 should return 9`() {
        val computedCaptcha = Captcha().computeCaptcha("91212129")

        assertEquals(9, computedCaptcha)
    }

    @Test
    fun `captcha for 9 should return 0`() {
        val computedCaptcha = Captcha().computeCaptcha("9")

        assertEquals(0, computedCaptcha)
    }
}