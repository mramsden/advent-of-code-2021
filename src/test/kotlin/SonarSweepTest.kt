import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class SonarSweepTest {

    private val input = """
        199
        200
        208
        210
        200
        207
        240
        269
        260
        263
        """.trimIndent()

    @Test
    fun `depth increase count`() {
        assertEquals(7, SonarSweep.countDepthIncreases(input))
    }

    @Test
    fun `sliding window depth increase count`() {
        assertEquals(5, SonarSweep.countDepthIncreases(input, windowSize = 3))
    }
}
