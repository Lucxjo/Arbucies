package co.aplicared.jvm.juego.arbucies.util

enum class Compass(private val `val`: Int, private val description: String) {
    NORTH(0, "North"),
    EAST(1, "East"),
    SOUTH(2, "South"),
    WEST(3, "West");

    fun value(): Int {
        return `val`
    }

    fun desc(): String {
        return description
    }

}