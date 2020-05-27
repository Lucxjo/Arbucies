package co.aplicared.jvm.juego.arbucies.control

import java.awt.event.KeyEvent
import java.awt.event.KeyListener

class Keyboard : KeyListener {
    var up = false
    var down = false
    var left = false
    var right = false
    private var keys: BooleanArray = BooleanArray(256)

    open fun update() {
        up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W]
        down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S]
        left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A]
        right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D]
    }

    override fun keyTyped(e: KeyEvent?) {
    }

    override fun keyPressed(e: KeyEvent?) {
        keys[e!!.keyCode] = true
    }

    override fun keyReleased(e: KeyEvent?) {
        keys[e!!.keyCode] = false
    }
}