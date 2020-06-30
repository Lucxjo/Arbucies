package co.aplicared.jvm.juego.arbucies.entity.particle

import co.aplicared.jvm.juego.arbucies.graphics.Sprite
import co.aplicared.jvm.juego.arbúcies.entity.Entity
import co.aplicared.jvm.juego.arbúcies.graphics.Screen
import java.util.*
import kotlin.math.roundToInt

open class Particle(x: Int, y: Int, life: Int) : Entity() {
    private var sprite: Sprite
    private var life: Int

    protected var xa: Double? = null
    protected var ya: Double? = null

    protected var xx: Double
    protected var yy: Double

    private val random = Random()

    init {
        this.x = x
        this.y = y
        this.xx = x.toDouble()
        this.yy = y.toDouble()
        this.life = life
        sprite = Sprite.Particle.particleNormal

        this.xa = random.nextGaussian()
        this.ya = random.nextGaussian()
    }

    override fun update() {
        this.xx += xa!!
        this.yy += ya!!
    }

    override fun render(screen: Screen?) {
        screen?.renderSprite(xx.roundToInt(), yy.roundToInt(), sprite, true)
    }
}