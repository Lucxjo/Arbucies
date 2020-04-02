package co.aplicared.jvm.juego.arbucies.entity.mob

import co.aplicared.jvm.juego.arbúcies.control.Keyboard
import co.aplicared.jvm.juego.arbúcies.entity.mob.Mob
import co.aplicared.jvm.juego.arbúcies.graphics.PlayerSprites
import co.aplicared.jvm.juego.arbúcies.graphics.Screen
import co.aplicared.jvm.juego.arbúcies.graphics.Sprite
import co.aplicared.jvm.juego.arbúcies.util.Compass

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