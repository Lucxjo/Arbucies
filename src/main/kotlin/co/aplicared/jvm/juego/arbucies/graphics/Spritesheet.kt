/*
 * Copyright (c) 2020 Ludoviko (Louis Hollingworth). This file is subject to the GNU GPL V3.0
 */

package co.aplicared.jvm.juego.arbucies.graphics

import java.io.IOException
import javax.imageio.ImageIO

class Spritesheet(private var path: String, val size: Int) {
    var pixels = IntArray(size * size)
    
    init {
        load()
    }
    
    private fun load() {
        try {
            val image = ImageIO.read(Spritesheet::class.java.getResource(path))
            val w = image.width
            val h = image.height
            image.getRGB(0, 0, w, h, pixels, 0, w)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    
}