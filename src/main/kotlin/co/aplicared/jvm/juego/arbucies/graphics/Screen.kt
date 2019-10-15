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
            val yy = y + yPos
            //if (y < 0 || y >= _height) break
            for (x in 0 until _width) {
                val xx = x + xPos
                //if (x < 0 || x >= _width) break
                val tileIndex = ((xx shr 4) and mapSizeMask) + ((yy shr 4) and mapSizeMask) * mapSize
                pixels[x + y * _width] = tiles[tileIndex]
            }
        }
    }
}