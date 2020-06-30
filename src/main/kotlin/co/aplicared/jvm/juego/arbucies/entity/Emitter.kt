package co.aplicared.jvm.juego.arbucies.entity

import co.aplicared.jvm.juego.arbucies.entity.particle.Particle
import co.aplicared.jvm.juego.arbúcies.entity.Entity
import co.aplicared.jvm.juego.arbúcies.level.Level

class Emitter() : Entity() {
    private var entities = ArrayList<Entity>()
    lateinit var type: Type

    enum class Type {
        MOB, PARTICLE
    }

    constructor(x: Int, y: Int, t: Type, amount: Int, level: Level) : this() {
        init(level)
        this.x = x
        this.y = y
        this.type = t
        for (i in 0 until amount) {
            if (type == Type.PARTICLE) {
                level.add(Particle(x, y, 50))
            }
        }
    }
}