package co.aplicared.jvm.juego.arbucies

import co.aplicared.jvm.juego.arbúcies.control.Keyboard
import co.aplicared.jvm.juego.arbúcies.control.Mouse
import co.aplicared.jvm.juego.arbúcies.entity.mob.Player
import co.aplicared.jvm.juego.arbúcies.graphics.Screen
import co.aplicared.jvm.juego.arbúcies.level.Level
import co.aplicared.jvm.juego.arbúcies.level.TileCoord
import java.awt.Canvas
import java.awt.Color
import java.awt.Dimension
import java.awt.Font
import java.awt.image.BufferedImage
import java.awt.image.DataBufferInt
import javax.swing.JFrame

class Arbucies : Canvas(), Runnable {
    val serialVersionUID = 1L

    val title = "Arbúcies"
    val aWidth = 300
    val aHeight = aWidth / 16 * 9
    val scale = 3

    private lateinit var _gameThread: Thread
    var gameFrame: JFrame

    private var _isRunning = false

    private val _image = BufferedImage(aWidth, aHeight, BufferedImage.TYPE_INT_RGB)
    private var _pixels: IntArray = (_image.raster.dataBuffer as DataBufferInt).data

    private val _key: Keyboard
    private val _level: Level
    private val _screen: Screen
    private val _player: Player
    private val _mouse: Mouse

    init {
        val size = Dimension(aWidth * scale, aHeight * scale)
        val playerSpawn = TileCoord(20, 65)
        gameFrame = JFrame()
        preferredSize = size

        _key = Keyboard()
        _mouse = Mouse()
        _level = Level.spawn
        _screen = Screen(aWidth, aHeight)
        _player = Player(playerSpawn.x, playerSpawn.y, _key)
        _player.init(_level)

        addKeyListener(_key)
        addMouseListener(_mouse)
        addMouseMotionListener(_mouse)
    }

    override fun run() {
        var lastTime: Long = System.nanoTime()
        var timer: Long = System.currentTimeMillis()
        val ns: Double = 1000000000.0 / 60.0
        var delta = 0.0
        var frames = 0
        var ticks = 0
        requestFocus()
        while (_isRunning) {
            var now = System.nanoTime()
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
                gameFrame.title = "$title (K) || TPS: $ticks | FPS: $frames"
                ticks = 0
                frames = 0
            }
        }
        stop()
    }

    private fun render() {
        val bs = bufferStrategy

        if (bs == null) {
            createBufferStrategy(3)
            return
        }

        _screen.clear()

        val xScroll = _player.x - _screen.width / 2
        val yScroll = _player.y - _screen.height / 2

        _level.render(xScroll, yScroll, _screen)
        _player.render(_screen)

        for (i in _pixels.indices) {
            _pixels[i] = _screen.pixels[i]
        }

        val g = bs.drawGraphics
        g.drawImage(_image, 0, 0, width, height, null)
        g.color = Color.WHITE
        g.font = Font("Ubuntu", Font.PLAIN, 20)
        g.fillRect(Mouse.getMouseX() - 32, Mouse.getMouseY() - 32, 64, 64)
        g.drawString("Button: " + Mouse.getMouseB(), 80, 80)
        g.dispose()
        bs.show()
    }

    private fun tick() {
        _key.update()
        _player.update()
    }

    @Synchronized
    fun start() {
        _isRunning = true
        _gameThread = Thread(this, "$title (MAIN_GAME)")
        _gameThread.start()
    }

    @Synchronized
    fun stop() {
        try {
            _gameThread.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}

fun main(args: Array<String>) {
    val game = Arbucies()
    game.gameFrame.isResizable = false
    game.gameFrame.title = game.title
    game.gameFrame.add(game)
    game.gameFrame.pack()
    game.gameFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    game.gameFrame.setLocationRelativeTo(null)
    game.gameFrame.isVisible = true
    game.gameFrame.requestFocus()

    game.start()
}