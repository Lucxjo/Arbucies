package co.aplicared.jvm.juego.arbucies.graphics

import java.awt.image.BufferedImage
import java.io.IOException
import javax.imageio.ImageIO

class SpriteSheet(private val path: String, val size: Int) {
    var pixels = IntArray(size * size)

    companion object {
        val terrain = SpriteSheet("/textures/TerrainSS.png", 256)
    }

    init {
        load()
    }

    private fun load() {
        try {
            val image: BufferedImage = ImageIO.read(SpriteSheet::class.java.getResource(path))
            val w = image.width
            val h = image.height
            image.getRGB(0, 0, w, h, pixels, 0, w)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}