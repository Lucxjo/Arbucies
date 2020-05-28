package co.aplicared.jvm.juego.arbucies.entity.projectile

import co.aplicared.jvm.juego.arbucies.graphics.Sprite
import co.aplicared.jvm.juego.arbúcies.graphics.Screen
import kotlin.math.cos
import kotlin.math.sin

class WizardProjectile(x: Double, y: Double, dir: Double) : Projectile(x, y, dir) {
    companion object {
        var FIRE_RATE = 15
    }

    init {
        range = random.nextDouble(100.0) + 100.0
        damage = 20.0
        speed = 4.0
        sprite = Sprite.Projectile.ballProjectile
        nx = speed!!.times(cos(angle))
        ny = speed!!.times(sin(angle))
    }

    override fun update() {
        super.update()
        if (level.tileCollision(x, y, nx!!, ny!!, 7)) remove()
        move()
    }

    override fun move() {
        super.move()
        x = x.plus(nx!!)
        y = y.plus(ny!!)
        if (distance() > range!!) {
            remove()
        }
    }

    override fun render(screen: Screen?) {
        super.render(screen)
        screen?.renderProjectile(x.toInt() - 12, y.toInt() - 2, this)
    }
}
