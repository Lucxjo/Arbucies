package co.aplicared.jvm.juego.arbucies.level.tile

import co.aplicared.jvm.juego.arbucies.graphics.Sprite

class BrickTile(sprite: Sprite) : Tile(sprite) {
    override fun solid(): Boolean {
        return true
    }
}