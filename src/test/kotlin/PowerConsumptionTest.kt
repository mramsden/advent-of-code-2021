import kotlin.test.Test
import kotlin.test.assertEquals

class PowerConsumptionTest {

    private val input = """
        00100
        11110
        10110
        10111
        10101
        01111
        00111
        11100
        10000
        11001
        00010
        01010
    """.trimIndent()

    @Test
    fun `calculates power consumption`() {
        assertEquals(198, PowerConsumption.computePowerConsumption(input))
    }

    @Test
    fun `calculates life support rating`() {
        assertEquals(230, PowerConsumption.lifeSupportRating(input))
    }

}
