package co.aplicared.jvm.juego.arbucies.level.tile

import co.aplicared.jvm.juego.arbucies.graphics.Sprite

class WoodTile(sprite: Sprite) : Tile(sprite) {

    override fun breakable(): Boolean {
        return true
    }

    override fun solid(): Boolean {
        return true
    }
}