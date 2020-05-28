package co.aplicared.jvm.juego.arbucies.level.tile

import co.aplicared.jvm.juego.arbucies.graphics.Sprite
import co.aplicared.jvm.juego.arbucies.graphics.Sprite.Tiles.birchWoodSprite
import co.aplicared.jvm.juego.arbucies.graphics.Sprite.Tiles.brickSprite
import co.aplicared.jvm.juego.arbucies.graphics.Sprite.Tiles.crackedStoneSprite
import co.aplicared.jvm.juego.arbucies.graphics.Sprite.Tiles.darkInfernoSprite
import co.aplicared.jvm.juego.arbucies.graphics.Sprite.Tiles.dirtSprite
import co.aplicared.jvm.juego.arbucies.graphics.Sprite.Tiles.lightGrassSprite
import co.aplicared.jvm.juego.arbucies.graphics.Sprite.Tiles.lightInfernoSprite
import co.aplicared.jvm.juego.arbucies.graphics.Sprite.Tiles.mossyCrackedStoneSprite
import co.aplicared.jvm.juego.arbucies.graphics.Sprite.Tiles.stoneSprite
import co.aplicared.jvm.juego.arbucies.graphics.Sprite.Tiles.voidSprite
import co.aplicared.jvm.juego.arbucies.graphics.Sprite.Tiles.waterSprite
import co.aplicared.jvm.juego.arbúcies.graphics.Screen

abstract class Tile(val sprite: Sprite) {
    protected var x: Int? = null
    protected var y: Int? = null

    open fun render(x: Int, y: Int, screen: Screen) {
    }

    open fun solid(): Boolean {
        return false
    }

    protected open fun breakable(): Boolean {
        return false
    }

    companion object {
        // Non-Solid Tiles
        var lightGrassTile: Tile = GrassTile(lightGrassSprite)
        var darkGrassTile: Tile = GrassTile(lightGrassSprite)
        var lightInfernoTile: Tile = GrassTile(lightInfernoSprite)
        var darkInfernoTile: Tile = GrassTile(darkInfernoSprite)
        var dirtTile: Tile = GrassTile(dirtSprite)
        var voidTile: Tile = VoidTile(voidSprite)

        // Solid tiles
        var brickTile: Tile = BrickTile(brickSprite)
        var stoneTile: Tile = StoneTile(stoneSprite)
        var cobbleTile: Tile = StoneTile(crackedStoneSprite)
        var mossyCobbleTile: Tile = StoneTile(mossyCrackedStoneSprite)
        var birchWoodTile: Tile = WoodTile(birchWoodSprite)
        var waterTile: Tile = WaterTile(waterSprite)
    }
}