/*
 * Copyright (c) 2020 Ludoviko (Louis Hollingworth). This file is subject to the GNU GPL V3.0
 */

package co.aplicared.jvm.juego.arbucies.level.tile

import co.aplicared.jvm.juego.arbucies.graphics.draw.Sprites

enum class Tiles(private val tile: Tile) {
    GRASS(GrassTile(Sprites.GRASS.get())),
    VOID(VoidTile(Sprites.VOID.get()));
    
    fun get(): Tile {
        return tile
    }
}