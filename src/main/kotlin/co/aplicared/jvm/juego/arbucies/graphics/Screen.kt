package co.aplicared.jvm.juego.arbucies.graphics

import kotlin.random.Random

class Screen(private val _width: Int, private val _height: Int) {
    var pixels: IntArray = IntArray(_height * _width)
    val mapSize = 64
    val mapSizeMask = mapSize - 1
    private var tiles: IntArray = IntArray(mapSize * mapSize)

    private var random = Random

    init {
        for (i in 0 until mapSize * mapSize) {
            tiles[i] = random.nextInt(0xFFFFFF)
        }
    }

    fun clear() {
        pixels.fill(0)
    }

    fun render(xPos: Int, yPos: Int) {
        for (y in 0 until _height) {
            val yp = y + yPos
            if (yp < 0 || yp >= _height) continue
            for (x in 0 until _width) {
                val xp = x + xPos
                if (xp < 0 || xp >= _width) continue
                pixels[xp + yp * _width] =
                    Sprite.grass.pixels[(x and 15) + (y and 15) * Sprite.grass.size] //tiles[tileIndex]
            }
        }
    }
}