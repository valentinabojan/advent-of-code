package day_21

import org.junit.Test
import kotlin.test.assertTrue

class ImageTransformationsTest {

    private val image = arrayOf(charArrayOf('.', '#', '.'), charArrayOf('.', '.', '#'), charArrayOf('#', '#', '#'))
    private val transformations = ImageTransformations()

    @Test
    fun `given input image when flipHorizontally is applied then correct image is returned`() {
        val expectedImage = arrayOf(charArrayOf('.', '#', '.'), charArrayOf('#', '.', '.'), charArrayOf('#', '#', '#'))

        assertTrue { expectedImage.contentDeepEquals(transformations.flipHorizontally(image)) }
    }

    @Test
    fun `given input image when flipVertically is applied then correct image is returned`() {
        val expectedImage = arrayOf(charArrayOf('#', '#', '#'), charArrayOf('.', '.', '#'), charArrayOf('.', '#', '.'))

        assertTrue { expectedImage.contentDeepEquals(transformations.flipVertically(image)) }
    }

    @Test
    fun `given input image when flipByFirstDiagonal is applied then correct image is returned`() {
        val expectedImage = arrayOf(charArrayOf('.', '.', '#'), charArrayOf('#', '.', '#'), charArrayOf('.', '#', '#'))

        assertTrue { expectedImage.contentDeepEquals(transformations.flipByFirstDiagonal(image)) }
    }

    @Test
    fun `given input image when flipBySecondDiagonal is applied then correct image is returned`() {
        val expectedImage = arrayOf(charArrayOf('#', '#', '.'), charArrayOf('#', '.', '#'), charArrayOf('#', '.', '.'))

        assertTrue { expectedImage.contentDeepEquals(transformations.flipBySecondDiagonal(image)) }
    }

    @Test
    fun `given input image when rotate 90 counterclockwise is applied then correct image is returned`() {
        val expectedImage = arrayOf(charArrayOf('.', '#', '#'), charArrayOf('#', '.', '#'), charArrayOf('.', '.', '#'))

        assertTrue { expectedImage.contentDeepEquals(transformations.rotate(image)) }
    }

    @Test
    fun `given input image when rotate 180 counterclockwise is applied then correct image is returned`() {
        val expectedImage = arrayOf(charArrayOf('#', '#', '#'), charArrayOf('#', '.', '.'), charArrayOf('.', '#', '.'))

        assertTrue { expectedImage.contentDeepEquals(transformations.rotate(transformations.rotate(image))) }
    }

    @Test
    fun `given input image when rotate 270 counterclockwise is applied then correct image is returned`() {
        val expectedImage = arrayOf(charArrayOf('#', '.', '.'), charArrayOf('#', '.', '#'), charArrayOf('#', '#', '.'))

        assertTrue { expectedImage.contentDeepEquals(transformations.rotate(transformations.rotate(transformations.rotate(image)))) }
    }

    @Test
    fun `given input image when rotate 360 counterclockwise is applied then initial image is returned`() {
        assertTrue { image.contentDeepEquals(transformations.rotate(transformations.rotate(transformations.rotate(transformations.rotate(image))))) }
    }

    @Test
    fun `given input image when rotate 90 rotateClockWise is applied then correct image is returned`() {
        val expectedImage = arrayOf(charArrayOf('#', '.', '.'), charArrayOf('#', '.', '#'), charArrayOf('#', '#', '.'))

        assertTrue { expectedImage.contentDeepEquals(transformations.rotateClockWise(image)) }
    }

}