package co.aplicared.jvm.juego.arbucies.level.tile

import co.aplicared.jvm.juego.arbucies.graphics.Screen
import co.aplicared.jvm.juego.arbucies.graphics.Sprite

class VoidTile(voidSprite: Sprite) : Tile(voidSprite) {
    override fun render(x: Int, y: Int, screen: Screen) {
        screen.renderTile(x, y, this)
    }
}
