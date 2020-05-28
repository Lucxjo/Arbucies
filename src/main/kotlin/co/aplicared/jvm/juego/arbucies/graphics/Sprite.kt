package co.aplicared.jvm.juego.arbucies.graphics

class Sprite {
    var sheet: SpriteSheet? = null
    var xCoord: Int? = null
    var yCoord: Int? = null
    var size: Int? = null

    var width: Int? = null
        private set

    var height: Int? = null
        private set

    lateinit var pixels: IntArray

    constructor(size: Int, xCoord: Int, yCoord: Int, sheet: SpriteSheet) {
        this.size = size
        this.xCoord = xCoord * size
        this.yCoord = yCoord * size
        this.sheet = sheet
        pixels = IntArray(size * size)
        load()
    }

    constructor(size: Int, colour: Int) {
        this.size = size
        pixels = IntArray(size * size)
        setColour(colour)
    }

    constructor(width: Int, height: Int, colour: Int) {
        this.width = width
        this.height = height
        pixels = IntArray(width * height)
        setColour(colour)
    }

    private fun setColour(colour: Int) {
        if (size != null) {
            for (i in 0 until size!!) {
                pixels[i] = colour
            }
        } else {
            for (i in 0 until width!! * height!!) {
                pixels[i] = colour
            }
        }
    }

    private fun load() {
        for (y in 0 until size!!) {
            for (x in 0 until size!!) {
                pixels[x + y * size!!] = sheet!!.pixels[(x + xCoord!!) + (y + yCoord!!) * sheet!!.size]
            }
        }
    }

    object Tiles {
        val lightGrassSprite = Sprite(16, 0, 0, SpriteSheet.terrain)
        var darkGrassSprite = Sprite(16, 1, 0, SpriteSheet.terrain)
        var dirtSprite = Sprite(16, 2, 0, SpriteSheet.terrain)
        var stoneSprite = Sprite(16, 3, 0, SpriteSheet.terrain)
        var lightInfernoSprite = Sprite(16, 4, 0, SpriteSheet.terrain)
        var darkInfernoSprite = Sprite(16, 5, 0, SpriteSheet.terrain)
        var brickSprite = Sprite(16, 0, 1, SpriteSheet.terrain)
        var waterSprite = Sprite(16, 1, 1, SpriteSheet.terrain)
        var crackedStoneSprite = Sprite(16, 2, 1, SpriteSheet.terrain)
        var mossyCrackedStoneSprite = Sprite(16, 3, 1, SpriteSheet.terrain)
        var birchWoodSprite = Sprite(16, 0, 2, SpriteSheet.terrain)
        var voidSprite = Sprite(16, 0x000)
    }

    object Player {
        // Back
        var player0Bck0 = Sprite(32, 0, 0, SpriteSheet.player)
        var player0Bck1 = Sprite(32, 0, 1, SpriteSheet.player)

        // Right
        var player0Rght0 = Sprite(32, 1, 0, SpriteSheet.player)
        var player0Rght1 = Sprite(32, 1, 1, SpriteSheet.player)

        // Front
        var player0Frnt0 = Sprite(32, 2, 0, SpriteSheet.player)
        var player0Frnt1 = Sprite(32, 2, 1, SpriteSheet.player)

        // Left
        var player0Left0 = Sprite(32, 3, 0, SpriteSheet.player)
        var player0Left1 = Sprite(32, 3, 1, SpriteSheet.player)
    }

    object Projectile {
        var ballProjectile = Sprite(16, 0, 0, SpriteSheet.projectile)
    }
}