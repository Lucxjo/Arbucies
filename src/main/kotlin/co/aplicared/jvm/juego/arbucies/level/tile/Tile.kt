package co.aplicared.jvm.juego.arbucies.level.tile

import co.aplicared.jvm.juego.arbucies.graphics.Screen
import co.aplicared.jvm.juego.arbucies.graphics.Sprite

open class Tile(val sprite: Sprite) {
    open var x: Int? = null
    open var y: Int? = null

    companion object {
        val grass = GrassTile(Sprite.grass)
    }

    open fun render(x: Int, y: Int, screen: Screen) {
    }

    open fun solid(): Boolean {
        return false
    }

}