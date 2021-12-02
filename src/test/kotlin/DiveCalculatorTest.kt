import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class DiveCalculatorTest {

    private val input = """
        forward 5
        down 5
        forward 8
        up 3
        down 8
        forward 2
        """.trimIndent()

    @Test
    fun `can compute distance covered`() {
        assertEquals(150, DiveCalculator.measureNavigationDistance(input))
    }

    @Test
    fun `can compute distance covered with aim`() {
        assertEquals(900, DiveCalculator.measureNavigationDistance(input, aimEnabled = true))
    }
}
