/*
 * Copyright (c) 2020 Ludoviko (Louis Hollingworth). This file is subject to the GNU GPL V3.0
 */

package co.aplicared.jvm.juego.arbucies.level

import co.aplicared.jvm.juego.arbucies.graphics.Screen
import co.aplicared.jvm.juego.arbucies.level.tile.*

open class Level {
    protected var width: Int? = null
    protected var height: Int? = null
    protected var tiles: IntArray? = null
    
    constructor(width: Int, height: Int) {
        this.width = width
        this.height = height
        tiles = IntArray(width * height)
        generateLevel()
    }
    
    constructor(path: String) {
        loadLevel(path)
    }
    
    protected fun loadLevel(path: String) {
    }
    
    protected open fun generateLevel() {
    }
    
    fun update() {}
    
    fun render(xScroll: Int, yScroll: Int, screen: Screen) {
        val x0 = xScroll shr 4;
        val x1 = (xScroll + screen.width) shr 4
        val y0 = yScroll shr 4;
        val y1 = (yScroll + screen.height) shr 4
    }
    
    fun getTile(x: Int, y: Int): Tile? {
        if (tiles!![x + y + width!!] == 0) return Tiles.GRASS.get()
        return Tiles.VOID.get()
    }
    
    protected fun time() {}
}