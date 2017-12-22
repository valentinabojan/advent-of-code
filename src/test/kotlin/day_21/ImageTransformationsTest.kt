package day_21

import org.junit.Test
import kotlin.test.assertEquals

class ImageTransformationsTest {

    private val image = listOf(listOf(".", "#", "."), listOf(".", ".", "#"), listOf("#", "#", "#"))
    private val transformations = ImageTransformations()

    @Test
    fun `given input image when flipHorizontally is applied then correct image is returned`() {
        val expectedImage = listOf(listOf(".", "#", "."), listOf("#", ".", "."), listOf("#", "#", "#"))

        assertEquals(expectedImage, transformations.flipHorizontally(image))
    }

    @Test
    fun `given input image when flipVertically is applied then correct image is returned`() {
        val expectedImage = listOf(listOf("#", "#", "#"), listOf(".", ".", "#"), listOf(".", "#", "."))

        assertEquals(expectedImage, transformations.flipVertically(image))
    }

    @Test
    fun `given input image when flipByFirstDiagonal is applied then correct image is returned`() {
        val expectedImage = listOf(listOf(".", ".", "#"), listOf("#", ".", "#"), listOf(".", "#", "#"))


        assertEquals(expectedImage, transformations.flipByFirstDiagonal(image))
    }

    @Test
    fun `given input image when flipBySecondDiagonal is applied then correct image is returned`() {
        val expectedImage = listOf(listOf("#", "#", "."), listOf("#", ".", "#"), listOf("#", ".", "."))

        assertEquals(expectedImage, transformations.flipBySecondDiagonal(image))
    }

    @Test
    fun `given input image when rotate 90 counterclockwise is applied then correct image is returned`() {
        val expectedImage = listOf(listOf(".", "#", "#"), listOf("#", ".", "#"), listOf(".", ".", "#"))

        assertEquals(expectedImage, transformations.rotate(image))
    }

    @Test
    fun `given input image when rotate 180 counterclockwise is applied then correct image is returned`() {
        val expectedImage = listOf(listOf("#", "#", "#"), listOf("#", ".", "."), listOf(".", "#", "."))

        assertEquals(expectedImage, transformations.rotate(transformations.rotate(image)))
    }

    @Test
    fun `given input image when rotate 270 counterclockwise is applied then correct image is returned`() {
        val expectedImage = listOf(listOf("#", ".", "."), listOf("#", ".", "#"), listOf("#", "#", "."))

        assertEquals(expectedImage, transformations.rotate(transformations.rotate(transformations.rotate(image))))
    }

    @Test
    fun `given input image when rotate 360 counterclockwise is applied then initial image is returned`() {
        assertEquals(image, transformations.rotate(transformations.rotate(transformations.rotate(transformations.rotate(image)))))
    }

    @Test
    fun `given input image when rotate 90 rotateClockWise is applied then correct image is returned`() {
        val expectedImage = listOf(listOf("#", ".", "."), listOf("#", ".", "#"), listOf("#", "#", "."))

        assertEquals(expectedImage, transformations.rotateClockWise(image))
    }

}