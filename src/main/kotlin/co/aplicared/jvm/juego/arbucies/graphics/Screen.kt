/*
 * Copyright (c) 2020 Ludoviko (Louis Hollingworth). This file is subject to the GNU GPL V3.0
 */

package co.aplicared.jvm.juego.arbucies.graphics

import kotlin.random.Random

class Screen(private val width: Int, private val height: Int) {
    var pixels = IntArray(width * height)
    var tiles = IntArray(64 * 64)
    
    private val random = Random
    
    init {
        for (i in 0 until 64 * 64) {
            tiles[i] = random.nextInt(0xffffff)
        }
    }
    
    fun render() {
        for (y in 0 until height) {
            for (x in 0 until width) {
                if (y >= height || x >= width || y < 0 || x < 0) break
                val tileIndex = (x shr 4) + (y shr 4) * 64
                pixels[x + y * width] = tiles[tileIndex]
            }
        }
    }
    
    fun clear() {
        for (i in pixels.indices) {
            pixels[i] = 0
        }
    }
}