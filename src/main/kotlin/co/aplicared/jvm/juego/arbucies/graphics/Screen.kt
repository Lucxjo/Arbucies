package co.aplicared.jvm.juego.arbucies.graphics

import co.aplicared.jvm.juego.arbucies.level.tile.Tile
import kotlin.random.Random

class Screen(val width: Int, val height: Int) {
    var pixels: IntArray = IntArray(height * width)
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
        for (y in 0 until height) {
            val yp = y + yPos
            if (yp < 0 || yp >= height) continue
            for (x in 0 until width) {
                val xp = x + xPos
                if (xp < 0 || xp >= width) continue
                pixels[xp + yp * width] =
                    Sprite.grass.pixels[(x and 15) + (y and 15) * Sprite.grass.size] //tiles[tileIndex]
            }
        }
    }

    open fun renderTile(xPos: Int, yPos: Int, tile: Tile) {
        for (y in 0 until tile.sprite.size) {
            val ya = y + yPos
            for (x in 0 until tile.sprite.size) {
                val xa = x + xPos
                if (xa < 0 || xa >= width || ya < 0 || ya >= height) break
                pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.size]
            }
        }
    }
}