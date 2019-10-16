package co.aplicared.jvm.juego.arbucies.level

import co.aplicared.jvm.juego.arbucies.graphics.Screen

class Level {
    private var width: Int? = null
    private var height: Int? = null
    private lateinit var tiles: IntArray

    constructor(width: Int, height: Int) {
        this.width = width
        this.height = height
        tiles = IntArray(width * height)
        generateLevel()
    }

    constructor(path: String) {
        loadLevel(path)
    }

    private fun generateLevel() {
        //
    }

    private fun loadLevel(path: String) {}

    private fun time() {}

    fun update() {
    }

    fun render(xScroll: Int, yScroll: Int, screen: Screen) {
    }
}