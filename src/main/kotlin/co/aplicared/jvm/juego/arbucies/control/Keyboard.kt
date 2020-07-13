/*
 * Copyright (c) 2020 Ludoviko (Louis Hollingworth). This file is subject to the GNU GPL V3.0
 */

package co.aplicared.jvm.juego.arbucies.control

import java.awt.event.*

open class Keyboard : KeyListener {
    var up = false
        private set
    
    var down = false
        private set
    
    var left = false
        private set
    
    var right = false
        private set
    
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