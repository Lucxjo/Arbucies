/*
 * Copyright (c) 2020 Ludoviko (Louis Hollingworth). This file is subject to the GNU GPL V3.0
 */

package co.aplicared.jvm.juego.arbucies.level

import co.aplicared.jvm.juego.arbucies.graphics.Screen

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
    
    fun render(xScroll: Int, yScroll: Int, screen: Screen) {}
    
    protected fun time() {}
}