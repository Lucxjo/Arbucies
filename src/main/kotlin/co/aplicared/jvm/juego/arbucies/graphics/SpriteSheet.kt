package co.aplicared.jvm.juego.arbucies.graphics

import java.awt.image.BufferedImage
import java.io.IOException
import javax.imageio.ImageIO

class SpriteSheet(val path: String, val size: Int) {
    val pixels: IntArray = IntArray(size * size)

    companion object Sheets {
        val terrain = SpriteSheet("/textures/TerrainSS.png", 256)
        val player = SpriteSheet("/textures/PlayerSS.png", 256)
        val projectile = SpriteSheet("/textures/ProjectileSS.png", 48)
    }

    init {
        load()
    }

    fun load() {
        try {
            val i: BufferedImage = ImageIO.read(SpriteSheet::class.java.getResource(path))
            val w = i.width
            val h = i.height
            i.getRGB(0, 0, w, h, pixels, 0, w)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

}