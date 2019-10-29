package co.aplicared.jvm.juego.arbucies.graphics

import co.aplicared.jvm.juego.arbucies.level.tile.Tile
import kotlin.random.Random

class Screen(val width: Int = 300, val height: Int = width / 16 * 10) {
    var pixels: IntArray = IntArray(height * width)
    val mapSize = 64
    val mapSizeMask = mapSize - 1

    var xOffset: Int? = null
    var yOffset: Int? = null

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

    fun renderTile(xPos: Int, yPos: Int, tile: Tile) {
        val xp = xPos - (xOffset ?: 0)
        val yp = yPos - (yOffset ?: 0)
        for (y in 0 until tile.sprite.size) {
            val ya = y + yp
            for (x in 0 until tile.sprite.size) {
                val xa = x + xp
                if (xa < 0 || xa >= width || ya < 0 || ya >= height) break
                pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.size]
            }
        }
    }

    fun setOffset(xOffset: Int, yOffset: Int) {
        this.xOffset = xOffset
        this.yOffset = yOffset
    }
}