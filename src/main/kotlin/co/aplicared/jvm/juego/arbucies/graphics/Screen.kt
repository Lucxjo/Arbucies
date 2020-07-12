/*
 * Copyright (c) 2020 Ludoviko (Louis Hollingworth). This file is subject to the GNU GPL V3.0
 */

/*
 * Copyright (c) 2020 Ludoviko (Louis Hollingworth). This file is subject to the GNU GPL V3.0
 */

/*
 * Copyright (c) 2020 Ludoviko (Louis Hollingworth). This file is subject to the GNU GPL V3.0
 */

package co.aplicared.jvm.juego.arbucies.graphics

class Screen(private val width: Int, private val height: Int) {
    var pixels = IntArray(width * height)
    
    fun render() {
        for (y in 0 until height) {
            for (x in 0 until width) {
                pixels[x + y * width] = 0xff00ff
            }
        }
    }
}