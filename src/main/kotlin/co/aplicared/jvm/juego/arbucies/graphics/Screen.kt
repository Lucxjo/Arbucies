/*
 * Copyright (c) 2020 Ludoviko (Louis Hollingworth). This file is subject to the GNU GPL V3.0
 */

package co.aplicared.jvm.juego.arbucies.graphics

import co.aplicared.jvm.juego.arbucies.graphics.draw.Sprites
import co.aplicared.jvm.juego.arbucies.level.tile.Tile
import kotlin.random.Random

class Screen(val width: Int, val height: Int) {
    val mapSize = 8
    val mapSizeMask = mapSize - 1
    var pixels = IntArray(width * height)
    var tiles = IntArray(mapSize * mapSize)
    
    private val random = Random
    
    init {
        for (i in 0 until mapSize * mapSize) {
            tiles[i] = random.nextInt(0xffffff)
        }
    }
    
    fun render(xOffset: Int, yOffset: Int) {
        for (y in 0 until height) {
            val yy = y + yOffset
            if (yy < 0 || yy >= height) continue
            for (x in 0 until width) {
                val xx = x + xOffset
                if (xx < 0 || xx >= width) continue
                pixels[xx + yy * width] = Sprites.GRASS.get().pixels[(x and 15) + (y and 15) * Sprites
                    .GRASS.get()
                    .size]
            }
        }
    }
    
    fun renderTile(xp: Int, yp: Int, tile: Tile) {
        for (y in 0 until tile.sprite.size) {
            val ya = y + yp
            for (x in 0 until tile.sprite.size) {
                val xa = x + xp
                if (xa < 0 || ya < 0 || xa >= width || ya >= height) break
                pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.size]
            }
        }
    }
    
    fun clear() {
        for (i in pixels.indices) {
            pixels[i] = 0
        }
    }
}