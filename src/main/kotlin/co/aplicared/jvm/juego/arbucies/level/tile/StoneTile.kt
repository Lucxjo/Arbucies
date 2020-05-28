package co.aplicared.jvm.juego.arbucies.level.tile

import co.aplicared.jvm.juego.arbucies.graphics.Sprite
import co.aplicared.jvm.juego.arbúcies.graphics.Screen

class StoneTile(sprite: Sprite) : Tile(sprite) {
    override fun solid(): Boolean {
        return true
    }

    override fun render(x: Int, y: Int, screen: Screen) {
        screen.renderTile(x shl 4, y shl 4, this)
    }
}