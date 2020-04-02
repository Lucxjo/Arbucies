package co.aplicared.jvm.juego.arbucies.entity.mob

import co.aplicared.jvm.juego.arbucies.Arbucies
import co.aplicared.jvm.juego.arbucies.control.Mouse
import co.aplicared.jvm.juego.arbúcies.control.Keyboard
import co.aplicared.jvm.juego.arbúcies.entity.mob.Mob
import co.aplicared.jvm.juego.arbúcies.graphics.PlayerSprites
import co.aplicared.jvm.juego.arbúcies.graphics.Screen
import co.aplicared.jvm.juego.arbúcies.graphics.Sprite
import co.aplicared.jvm.juego.arbúcies.util.Compass
import kotlin.math.atan2

open class Player(private var input: Keyboard) : Mob() {
    private var pSprite: Sprite = PlayerSprites.BACK.sprite()
    private var anim = 0
    private var walking = false

    constructor(x: Int, y: Int, input: Keyboard) : this(input) {
        this.x = x
        this.y = y
    }

    override fun update() {
        var xa = 0
        var ya = 0
        if (anim < 200) anim++
        else anim = 0
        if (input.up) ya--
        if (input.down) ya++
        if (input.left) xa--
        if (input.right) xa++

        walking = if (xa != 0 || ya != 0) {
            move(xa, ya)
            true
        } else false

        updateShooting()
    }

    private fun updateShooting() {
        if (Mouse.mouseB == 1) {
            val dx: Double = Mouse.mouseX.toDouble() - Arbucies.getWindowWidth() / 2
            val dy: Double = Mouse.mouseY.toDouble() - Arbucies.getWindowHeight() / 2
            val direction = atan2(dy, dx)
            shoot(x, y, direction)
        }
    }

    override fun render(screen: Screen) {
        if (dir == Compass.NORTH) {
            pSprite = PlayerSprites.BACK.sprite()
            if (walking) {
                pSprite = if (anim % 20 > 10) {
                    PlayerSprites.BACK.sprite()
                } else {
                    PlayerSprites.BACK.altSprite()
                }
            }
        }

        if (dir == Compass.SOUTH) {
            pSprite = PlayerSprites.FRONT.sprite()
            if (walking) {
                pSprite = if (anim % 20 > 10) {
                    PlayerSprites.FRONT.sprite()
                } else {
                    PlayerSprites.FRONT.altSprite()
                }
            }
        }
        if (dir == Compass.EAST) {
            pSprite = PlayerSprites.RIGHT.sprite()
            if (walking) {
                pSprite = if (anim % 20 > 10) {
                    PlayerSprites.RIGHT.sprite()
                } else {
                    PlayerSprites.RIGHT.altSprite()
                }
            }
        }
        if (dir == Compass.WEST) {
            pSprite = PlayerSprites.LEFT.sprite()
            if (walking) {
                pSprite = if (anim % 20 > 10) {
                    PlayerSprites.LEFT.sprite()
                } else {
                    PlayerSprites.LEFT.altSprite()
                }
            }
        }

        screen.renderPlayer(x - 16, y - 16, pSprite)
    }
}