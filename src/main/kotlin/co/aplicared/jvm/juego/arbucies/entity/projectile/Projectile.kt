package co.aplicared.jvm.juego.arbucies.entity.projectile

import co.aplicared.jvm.juego.arbúcies.entity.Entity
import co.aplicared.jvm.juego.arbúcies.graphics.Sprite
import kotlin.math.abs
import kotlin.math.roundToInt
import kotlin.math.sqrt

abstract class Projectile(x: Double, y: Double, dir: Double) : Entity() {
    protected val xOrigin: Int = x.roundToInt()
    protected val yOrigin: Int = y.roundToInt()
    protected var angle: Double = dir.toDouble()
    lateinit var sprite: Sprite
    protected var nx: Double? = null
    protected var ny: Double? = null
    protected var speed: Double? = null
    protected var rateOfFire: Double? = null
    protected var range: Double? = null
    protected var damage: Double? = null

    init {
        this.x = x
        this.y = y
    }

    protected open fun move() {}

    fun getSpriteSize(): Int {
        return sprite.size
    }

    protected open fun distance(): Double {
        return abs(sqrt(((xOrigin - x) * (xOrigin - x)) + ((yOrigin - y) * (yOrigin - y))))
    }
}