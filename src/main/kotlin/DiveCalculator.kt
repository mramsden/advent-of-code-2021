object DiveCalculator {

    fun measureNavigationDistance(input: String, aimEnabled: Boolean = false): Int {
        var horizontal = 0
        var depth = 0
        var aim = 0

        for (step in input.reader().readLines()) {
            val (command, distance) = step.split(" ")
            when (command) {
                "forward" -> {
                    if (aimEnabled) {
                        depth += aim * distance.toInt()
                    }
                    horizontal += distance.toInt()
                }
                "down" -> {
                    if (aimEnabled) {
                        aim += distance.toInt()
                    } else {
                        depth += distance.toInt()
                    }
                }
                "up" -> {
                    if (aimEnabled) {
                        aim -= distance.toInt()
                    } else {
                        depth -= distance.toInt()
                    }
                }
                else -> println("unknown command $command")
            }
        }

        return horizontal * depth
    }
}

fun main() {
    val input = DiveCalculator.javaClass.getResourceAsStream("divecalculatorinput.txt")?.use {
        it.bufferedReader().readText()
    } ?: ""
    println(DiveCalculator.measureNavigationDistance(input, aimEnabled = true))
}
