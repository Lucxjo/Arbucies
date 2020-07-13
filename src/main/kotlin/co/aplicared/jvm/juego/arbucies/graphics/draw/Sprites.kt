/*
 * Copyright (c) 2020 Ludoviko (Louis Hollingworth). This file is subject to the GNU GPL V3.0
 */

/*
 * Copyright (c) 2020 Ludoviko (Louis Hollingworth). This file is subject to the GNU GPL V3.0
 */

package co.aplicared.jvm.juego.arbucies.graphics.draw

enum class Sprites(private val sprite: Sprite) {
    GRASS(
        Sprite(
            16,
            0,
            0,
            Spritesheets.TERRAIN.get()
        )
    );
    
    fun get(): Sprite {
        return sprite
    }
}