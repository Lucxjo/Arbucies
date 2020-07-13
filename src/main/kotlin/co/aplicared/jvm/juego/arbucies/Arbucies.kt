/*
 * Copyright (c) 2020 Ludoviko (Louis Hollingworth). This file is subject to the GNU GPL V3.0
 */

package co.aplicared.jvm.juego.arbucies

import co.aplicared.jvm.juego.arbucies.control.Keyboard
import co.aplicared.jvm.juego.arbucies.graphics.Screen
import java.awt.*
import java.awt.image.*
import javax.swing.JFrame

class Arbucies : Runnable, Canvas() {

    companion object {
        private const val serialVersionUID: Long = 1
    }
    
    val aWidth = 300
    val aHeight = aWidth / 16 * 10
    val scale = 3
    
    lateinit var thread: Thread
    val frame: JFrame
    private var running = false
    
    private val screen: Screen
    private val key: Keyboard
    
    private val image = BufferedImage(aWidth, aHeight, BufferedImage.TYPE_INT_RGB)
    private var pixels = (image.raster.dataBuffer as DataBufferInt).data
    
    init {
        val size = Dimension(aWidth * scale, aHeight * scale)
        preferredSize = size
    
        frame = JFrame()
        screen = Screen(aWidth, aHeight)
        key = Keyboard()
    
        addKeyListener(key)
    }
    
    @Synchronized
    fun start() {
        running = true
        thread = Thread(this, "Arbucies: Game")
        thread.start()
    }

    @Synchronized
    fun stop() {
        running = false
        try {
            thread.join()
        } catch (e: InterruptedException) {
            print(e.localizedMessage)
        }
    }

    override fun run() {
        var lastTime: Long = System.nanoTime()
        var timer: Long = System.currentTimeMillis()
        val ns: Double = 1000000000.0 / 60.0
        var delta = 0.0
        var frames = 0
        var ticks = 0
    
        while (running) {
            val now = System.nanoTime()
            delta += (now - lastTime) / ns
            lastTime = now
        
            while (delta >= 1) {
                tick()
                ticks++
                delta--
            }
        
            render()
            frames++
        
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000
                frame.title = "Arbúcies (K) || TPS: $ticks | FPS: $frames"
                ticks = 0
                frames = 0
            }
        }
    
        stop()
    }
    
    fun tick() {
        key.update()
    }
    
    fun render() {
        val bs = bufferStrategy
        if (bs == null) {
            createBufferStrategy(3)
            return
        }
        
        screen.clear()
        screen.render()
    
        for (i in pixels.indices) {
            pixels[i] = screen.pixels[i]
        }
    
        val g = bs.drawGraphics
        g.drawImage(image, 0, 0, width, height, null)
        g.dispose()
        bs.show()
    }
}

fun main() {
    val game = Arbucies()
    game.frame.isResizable = false
    game.frame.title = "Arbúcies"
    game.frame.add(game)
    game.frame.pack()
    game.frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    game.frame.setLocationRelativeTo(null)
    game.frame.isVisible = true

    game.start()
}