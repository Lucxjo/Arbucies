package co.aplicared.jvm.juego.arbucies.entity.projectile

import co.aplicared.jvm.juego.arbúcies.graphics.Screen
import co.aplicared.jvm.juego.arbúcies.graphics.Sprite
import kotlin.math.cos
import kotlin.math.sin

class WizardProjectile(x: Double, y: Double, dir: Double) : Projectile(x, y, dir) {
    init {
        range = 200.0
        damage = 20.0
        rateOfFire = 15.0
        speed = 4.0

        sprite = Sprite.ballProjectile
        nx = speed!!.times(cos(angle))
        ny = speed!!.times(sin(angle))
    }

    override fun update() {
        super.update()
        move()
    }

    override fun move() {
        super.move()
        x = x.plus(nx!!)
        y = y.plus(ny!!)
    }

    override fun render(screen: Screen?) {
        super.render(screen)
        screen?.renderProjectile(x.toInt() - 12, y.toInt() - 2, this)
    }
}
