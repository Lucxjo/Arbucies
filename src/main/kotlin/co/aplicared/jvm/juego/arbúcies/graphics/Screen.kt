package co.aplicared.jvm.juego.arbúcies.graphics

import kotlin.random.Random

class Screen(private val _width: Int, private val _height: Int) {
    var pixels: IntArray = IntArray(_height * _width)
    private var tiles: IntArray = IntArray(64 * 64)
    private val _tileSize = 64 * 64

    private var random = Random

    init {
        for (i in 0 until _tileSize) {
            tiles[i] = random.nextInt(0xFFFFFF)
        }
    }

    fun clear() {
        pixels.fill(0)
    }

    fun render() {
        for (y in 0 until _height) {
            if (y < 0 || y >= _height) break
            for (x in 0 until _width) {
                if (x < 0 || x >= _width) break
                val tileIndex = (x shr 4) + (y shr 4) * 64
                pixels[x + y * _width] = tiles[tileIndex]
            }
        }
    }
}