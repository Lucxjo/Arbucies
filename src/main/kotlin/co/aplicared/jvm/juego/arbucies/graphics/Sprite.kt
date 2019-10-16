package co.aplicared.jvm.juego.arbucies.graphics

class Sprite(val size: Int, xCoord: Int, yCoord: Int, val sheet: SpriteSheet) {
    var pixels: IntArray = IntArray(size * size)
    var xCoord: Int = xCoord * size
    var yCoord: Int = yCoord * size

    companion object {
        val grass = Sprite(16, 0, 0, SpriteSheet.terrain)
    }

    init {
        load()
    }

    private fun load() {
        for (y in 0 until size) {
            for (x in 0 until size) {
                pixels[x + y * size] = sheet.pixels[(x + xCoord) + (y + yCoord) * sheet.size]
            }
        }
    }

}