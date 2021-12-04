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

    fun lifeSupportRating(input: String): Int {
        val filteredInput = input.split("\n").filter { it.isNotEmpty() }
        var oxygen: Collection<String> = filteredInput.toSet()
        var scrubber: Collection<String> = filteredInput.toSet()

        var oxygenPos = 0
        var scrubberPos = 0

        while (oxygen.size > 1) {
            val sum = oxygen.sumOf { reading ->
                when (reading[oxygenPos]) {
                    '0' -> -1
                    '1' -> 1
                    else -> 0
                } as Int
            }
            oxygen = oxygen.filter { reading ->
                reading[oxygenPos] == if (sum >= 0) '1' else '0'
            }
            oxygenPos += 1
        }

        while (scrubber.size > 1) {
            val sum = scrubber.sumOf { reading ->
                when (reading[scrubberPos]) {
                    '0' -> 1
                    '1' -> -1
                    else -> 0
                } as Int
            }
            scrubber = scrubber.filter { reading ->
                reading[scrubberPos] == if (sum <= 0) '0' else '1'
            }
            scrubberPos += 1
        }

        return oxygen.sumOf { it.toInt(radix = 2) } * scrubber.sumOf { it.toInt(radix = 2) }
    }
}

fun main() {
    val input = PowerConsumption.javaClass.getResourceAsStream("powerconsumptiondiagnosticinput.txt")?.use {
        it.bufferedReader().readText()
    } ?: ""
    println("Power consumption: ${PowerConsumption.computePowerConsumption(input)}")
    println("Life support rating: ${PowerConsumption.lifeSupportRating(input)}")
}
