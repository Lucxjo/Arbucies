/*
 * Copyright (c) 2020 Ludoviko (Louis Hollingworth). This file is subject to the GNU GPL V3.0
 */

package co.aplicared.jvm.juego.arbucies.graphics.draw

class Sprite(val size: Int, x: Int, y: Int, private var sheet: Spritesheet?) {
    private var x: Int = x * size
    private var y: Int = y * size
    
    var pixels: IntArray = IntArray(size * size)
        private set
    
    init {
        load()
    }
    
    private fun load() {
        for (y in 0 until size) {
            for (x in 0 until size) {
                pixels[x + y * size] = sheet?.pixels!![(x + this.x) + (y + this.y) * sheet?.size!!]
            }
        }
    }
    
}