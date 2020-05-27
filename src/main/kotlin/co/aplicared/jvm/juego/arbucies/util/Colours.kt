package co.aplicared.jvm.juego.arbucies.util

enum class Colours(private val rgb: Int, private val rgba: Int) {
    WHITE(0xFFFFFF, -0x1),
    BLACK(0x000000, -0x1000000),
    TRANSPARENT(0xef00ff, -0x10ff01),  // Textures
    TEX_LIGHT_GRASS(0xFF0000, -0x10000),
    TEX_DARK_GRASS(0xFFFF00, -0x100),
    TEX_LIGHT_INFERNO(0x7F0000, -0x810000),
    TEX_DARK_INFERNO(0x7F7f00, -0x808100),
    TEX_STONE(0xC70000, -0x390000),
    TEX_DIRT(0xC7c700, -0x383900),
    TEX_WATER(0xc7c7c7, -0x383839),

    // Points
    PNT_SPAWN(0x4bffff, -0xb40001);

    fun RGB(): Int {
        return rgb
    }

    fun RGBA(): Int {
        return rgba
    }

}