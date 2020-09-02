/*
 * Copyright (c) 2020 Ludoviko (Louis Hollingworth). This file is subject to the GNU GPL V3.0
 */

package co.aplicared.jvm.juego.arbucies.level.tile

import co.aplicared.jvm.juego.arbucies.graphics.Screen
import co.aplicared.jvm.juego.arbucies.graphics.draw.Sprite

open class Tile(var sprite: Sprite) {
    var x: Int? = null
    var y: Int? = null
    
    open fun render(x: Int, y: Int, screen: Screen) {
    }
    
    open fun solid(): Boolean {
        return false
    }
}