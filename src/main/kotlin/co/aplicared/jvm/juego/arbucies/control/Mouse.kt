package co.aplicared.jvm.juego.arbucies.control

import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.awt.event.MouseMotionListener

class Mouse : MouseListener, MouseMotionListener {

    companion object {
        var mouseX = -1
        var mouseY = -1
        var mouseB = -1
    }

    override fun mouseReleased(e: MouseEvent?) {
        mouseB = -1
    }

    override fun mouseEntered(e: MouseEvent?) {
    }

    override fun mouseClicked(e: MouseEvent?) {
    }

    override fun mouseExited(e: MouseEvent?) {
    }

    override fun mousePressed(e: MouseEvent?) {
        mouseB = e!!.button
    }

    override fun mouseMoved(e: MouseEvent?) {
        mouseX = e!!.x
        mouseY = e.y
    }

    override fun mouseDragged(e: MouseEvent?) {
        mouseX = e!!.x
        mouseY = e.y
    }
}