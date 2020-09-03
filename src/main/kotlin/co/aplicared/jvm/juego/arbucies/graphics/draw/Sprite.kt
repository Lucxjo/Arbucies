/*
 * Copyright (c) 2020 Ludoviko (Louis Hollingworth). This file is subject to the GNU GPL V3.0
 */

package co.aplicared.jvm.juego.arbucies.graphics.draw

class Sprite {
    var size: Int
    private var x: Int? = null
    private var y: Int? = null
    private var sheet: Spritesheet? = null
    
    var pixels: IntArray
        private set
    
    constructor(size: Int, x: Int, y: Int, sheet: Spritesheet?) {
        this.size = size
        this.pixels = IntArray(size * size)
        this.x = x * size
        this.y = y * size
        this.sheet = sheet
        load()
    }
    
    constructor(size: Int, colour: Int) {
        this.size = size
        this.pixels = IntArray(size * size)
        setColour(colour)
    }
    
    private fun setColour(colour: Int) {
        for (i in 0 until size * size) {
            pixels[i] = colour
        }
    }
    
    private fun load() {
        for (y in 0 until size) {
            for (x in 0 until size) {
                pixels[x + y * size] = sheet?.pixels!![(x + this.x!!) + (y + this.y!!) * sheet?.size!!]
            }
        }
    }
    
}