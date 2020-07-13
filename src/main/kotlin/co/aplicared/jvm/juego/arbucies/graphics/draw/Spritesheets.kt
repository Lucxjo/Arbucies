/*
 * Copyright (c) 2020 Ludoviko (Louis Hollingworth). This file is subject to the GNU GPL V3.0
 */

package co.aplicared.jvm.juego.arbucies.graphics.draw

enum class Spritesheets(private val sheet: Spritesheet) {
    TERRAIN(
        Spritesheet(
            "/textures/TerrainSS.png",
            256
        )
    );
    
    fun get(): Spritesheet {
        return sheet
    }
}