package co.aplicared.jvm.juego.arbucies

import co.aplicared.jvm.juego.arbucies.control.Keyboard
import co.aplicared.jvm.juego.arbucies.graphics.Screen
import java.awt.Canvas
import java.awt.Dimension
import java.awt.image.BufferedImage
import java.awt.image.DataBufferInt
import javax.swing.JFrame

class Game : Runnable, Canvas() {

    companion object {
        val gWidth = 300
        val gHeight = gWidth / 16 * 10
        val scale = 3

        val title = "Arbúcies"

        @JvmStatic
        fun main(args: Array<String>) {
            val game = Game()
            game._frame.isResizable = false
            game._frame.title = title
            game._frame.add(game)
            game._frame.pack()
            game._frame.requestFocus()
            game._frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
            game._frame.setLocationRelativeTo(null)
            game._frame.isVisible = true

            game.start()
        }
    }

    var _isRunning = false

    private lateinit var _gameThread: Thread
    private var _frame: JFrame
    private var _screen: Screen

    private var _key: Keyboard

    private val _image = BufferedImage(gWidth, gHeight, BufferedImage.TYPE_INT_RGB)
    private val _pixels = (_image.raster.dataBuffer as DataBufferInt).data

    private var xPos = 0
    private var yPos = 0

    init {
        val size = Dimension(gWidth * scale, gHeight * scale)
        _screen = Screen(gWidth, gHeight)
        _frame = JFrame()
        preferredSize = size
        _key = Keyboard()

        addKeyListener(_key)
    }

    override fun run(): Unit {
        var lastTime = System.nanoTime()
        var timer = System.currentTimeMillis()
        val ns = 1000000000.0 / 60.0
        var delta = 0.0
        var frames = 0
        var ticks = 0

        while (_isRunning) {
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
                _frame.title = "$title || TPS: $ticks | FPS: $frames"
                ticks = 0
                frames = 0
            }
        }
        stop()
    }

    @Synchronized
    fun start() {
        _gameThread = Thread(this, "Arbúcies Game Thread")
        _gameThread.start()
        _isRunning = true
    }

    @Synchronized
    fun stop() {
        try {
            _gameThread.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    fun tick() {
        _key.update()
    }

    fun render() {
        val bs = bufferStrategy
        if (bs == null) {
            createBufferStrategy(3)
            return
        }

        _screen.clear()
        _screen.render()

        System.arraycopy(_screen.pixels, 0, _pixels, 0, _pixels.size)

        val g = bs.drawGraphics
        g.drawImage(_image, 0, 0, width, height, null)
        g.dispose()
        bs.show()
    }
}