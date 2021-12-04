object PowerConsumption {

    fun computePowerConsumption(input: String): Int {
        var acc: MutableList<Int>? = null

        input.reader().forEachLine { reading ->
            if (acc == null) {
                acc = MutableList(reading.length) { 0 }
            }

            reading.forEachIndexed { index, readingBit ->
                when (readingBit) {
                    '0' -> acc!![index] = acc!![index] - 1
                    '1' -> acc!![index] = acc!![index] + 1
                }
            }
        }

        val gamma = acc!!.joinToString("") { if (it > 0) "1" else "0" }.toInt(radix = 2)
        val epsilon = acc!!.joinToString("") { if (it < 0) "1" else "0" }.toInt(radix = 2)

        return gamma * epsilon
    }
}

fun main() {
    val input = PowerConsumption.javaClass.getResourceAsStream("powerconsumptiondiagnosticinput.txt")?.use {
        it.bufferedReader().readText()
    } ?: ""
    println(PowerConsumption.computePowerConsumption(input))
}
