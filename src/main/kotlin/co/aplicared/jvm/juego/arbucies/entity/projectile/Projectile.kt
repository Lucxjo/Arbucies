package co.aplicared.jvm.juego.arbucies.entity.projectile

import co.aplicared.jvm.juego.arbúcies.entity.Entity
import co.aplicared.jvm.juego.arbúcies.graphics.Sprite
import kotlin.math.roundToInt

abstract class Projectile(x: Double, y: Double, dir: Double) : Entity() {
    protected val xOrigin: Int = x.roundToInt()
    protected val yOrigin: Int = y.roundToInt()
    protected var angle: Double = dir.toDouble()
    protected var sprite: Sprite? = null
    protected var nx: Double? = null
    protected var ny: Double? = null
    protected var speed: Double? = null
    protected var rateOfFire: Double? = null
    protected var range: Double? = null
    protected var damage: Double? = null

    init {
        this.x = x.toInt()
        this.y = y.toInt()
    }

    protected open fun move() {}
}