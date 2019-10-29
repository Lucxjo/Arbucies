package co.aplicared.jvm.juego.arbucies.graphics

open class Sprite {
    var size: Int
    var pixels: IntArray
    var xCoord: Int? = null
    var yCoord: Int? = null
    var sheet: SpriteSheet? = null

    companion object {
        val grass = Sprite(16, 0, 0, SpriteSheet.terrain)
        val voidSprite = Sprite(16, 0)
    }

    constructor(size: Int, xCoord: Int, yCoord: Int, sheet: SpriteSheet) {
        this.size = size
        this.xCoord = xCoord * size
        pixels = IntArray(size * size)
        this.yCoord = yCoord * size
        this.sheet = sheet
        load()
    }

    constructor(size: Int, colour: Int) {
        this.size = size
        pixels = IntArray(size * size)
        setColour(colour)
    }

    private fun setColour(colour: Int) {
        for (i in 0 until size * size) {
            pixels[i] = colour
        }
    }

    private fun load() {
        for (y in 0 until size) {
            for (x in 0 until size) {
                pixels[x + y * size] = sheet?.pixels?.get((x + xCoord!!) + (y + yCoord!!) * sheet!!.size)!!
            }
        }
    }

}