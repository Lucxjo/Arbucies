/*
 * Copyright (c) 2020 Ludoviko (Louis Hollingworth). This file is subject to the GNU GPL V3.0
 */

package co.aplicared.jvm.juego.arbucies.level

import co.aplicared.jvm.juego.arbucies.graphics.Screen

class Level {
    private var width: Int? = null
    private var height: Int? = null
    private var tiles: IntArray? = null
    
    constructor(width: Int, height: Int) {
        this.width = width
        this.height = height
        tiles = IntArray(width * height)
        generateLevel()
    }
    
    constructor(size: Int) {
        this.width = size
        this.height = size
        tiles = IntArray(size * size)
        generateLevel()
    }
    
    constructor(path: String) {
        loadLevel(path)
    }
    
    private fun loadLevel(path: String) {
    }
    
    private fun generateLevel() {
    }
    
    fun update() {}
    
    fun render(xScroll: Int, yScroll: Int, screen: Screen) {}
    
    private fun time() {}
}