package co.aplicared.jvm.juego.arbucies.level

open class TileCoord(x: Int, y: Int) {
    private val _tileSize = 16

    var x: Int = x * _tileSize
        set(value) {
            field = value * _tileSize
        }

    var y: Int = y * _tileSize
        set(value) {
            field = value * _tileSize
        }

    fun getArray(): IntArray {
        val r = IntArray(2)
        r[0] = x
        r[1] = y
        return r
    }
}