package co.aplicared.jvm.juego.arbucies.level

import co.aplicared.jvm.juego.arbucies.graphics.Screen

open class Level {
    protected open var width: Int? = null
    protected open var height: Int? = null
    protected open lateinit var tiles: IntArray

    constructor(width: Int, height: Int) {
        this.width = width
        this.height = height
        tiles = IntArray(width * height)
        generateLevel()
    }

    constructor(path: String) {
        loadLevel(path)
    }

    protected open fun generateLevel() {
        //
    }

    protected open fun loadLevel(path: String) {}

    protected open fun time() {}

    fun update() {
    }

    fun render(xScroll: Int, yScroll: Int, screen: Screen) {
        val x0 = xScroll shr 4
        val x1 = (xScroll + screen.width) shr 4
        val y0 = yScroll shr 4
        val y1 = (yScroll + screen.height) shr 4
    }
}