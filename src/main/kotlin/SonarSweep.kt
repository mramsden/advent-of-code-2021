object SonarSweep {

    fun countDepthIncreases(input: String, windowSize: Int = 1): Long {
        var increases: Long = 0
        var previousReading: Long? = null
        val lines = input.reader().readLines()
        for (index in 0..lines.size) {
            if (index + windowSize > lines.size) break
            val readings = lines.subList(index, index + windowSize)

            val currentReading = readings.sumOf { it.toLong() }
            if (previousReading != null && previousReading < currentReading) {
                increases += 1
            }
            previousReading = currentReading
        }
        return increases
    }
}

fun main() {
    val input = SonarSweep.javaClass.getResourceAsStream("sonarsweepinput.txt")?.use {
        it.bufferedReader().readText()
    } ?: ""
    println(SonarSweep.countDepthIncreases(input, windowSize = 3))
}
