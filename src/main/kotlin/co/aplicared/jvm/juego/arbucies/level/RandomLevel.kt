package co.aplicared.jvm.juego.arbucies.level

import kotlin.random.Random

class RandomLevel(width: Int, height: Int) : Level(width, height) {

    private val random = Random

    override fun generateLevel() {
        for (y in 0 until height!!) {
            for (x in 0 until width!!) {
                tiles[x + y * width!!] = random.nextInt(4)
            }
        }
    }
}