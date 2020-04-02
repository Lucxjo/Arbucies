package co.aplicared.jvm.juego.arbúcies;

import co.aplicared.jvm.juego.arbúcies.control.Keyboard;
import co.aplicared.jvm.juego.arbúcies.control.Mouse;
import co.aplicared.jvm.juego.arbúcies.entity.mob.Player;
import co.aplicared.jvm.juego.arbúcies.graphics.Screen;
import co.aplicared.jvm.juego.arbúcies.level.Level;
import co.aplicared.jvm.juego.arbúcies.level.TileCoord;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

@Deprecated
public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = 1L;

    public static final String title = "Arbúcies";
    public static int width = 300, height = width / 16 * 10, scale = 3;
    private Thread _gameThread;
    private JFrame _gameFrame;

    private boolean _isRunning = false;

    private BufferedImage _image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] _pixels = ((DataBufferInt) _image.getRaster().getDataBuffer()).getData();

    private Keyboard _key;
    private Level _level;
    private Screen _screen;
    private Player _player;
    private Mouse _mouse;

    public Game() {
        Dimension size = new Dimension(width * scale, height * scale);
        TileCoord playerSpawn = new TileCoord(20, 65);

        _gameFrame = new JFrame();
        setPreferredSize(size);

        _key = new Keyboard();
        _mouse = new Mouse();
        _level = Level.spawn;
        _screen = new Screen(width, height);
        _player = new Player(playerSpawn.getX(), playerSpawn.getY(), _key);
        _player.init(_level);

        addKeyListener(_key);
        addMouseListener(_mouse);
        addMouseMotionListener(_mouse);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game._gameFrame.setResizable(false);
        game._gameFrame.setTitle(title);
        game._gameFrame.add(game);
        game._gameFrame.pack();
        game._gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game._gameFrame.setLocationRelativeTo(null);
        game._gameFrame.setVisible(true);
        game._gameFrame.requestFocus();

        game.start();
    }

    @Override
    public void run() {
        if (System.getProperty("os.name").toLowerCase().equals("mac os x")) {
            System.out.println("macOS");
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            System.setProperty("com.apple.mrj.application.apple.menu.about.name", title);
        }
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        double ns = 1000000000.0 / 60.0;
        double delta = 0.0;
        int frames = 0;
        int ticks = 0;
        requestFocus();

        while (_isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while (delta >= 1) {
                tick();
                ticks++;
                delta--;
            }

            render();

            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                _gameFrame.setTitle(title + " (J) || TPS: " + ticks + " | FPS: " + frames);
                ticks = 0;
                frames = 0;
            }
        }
        stop();
    }

    private void render() {
        BufferStrategy bs = getBufferStrategy();

        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        _screen.clear();

        int xScroll = _player.x - _screen.width / 2;
        int yScroll = _player.y - _screen.height / 2;

        _level.render(xScroll, yScroll, _screen);
        _player.render(_screen);

        for (int i = 0; i < _pixels.length; i++) {
            _pixels[i] = _screen.pixels[i];
        }

        Graphics g = bs.getDrawGraphics();
        g.drawImage(_image, 0, 0, getWidth(), getHeight(), null);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Ubuntu", Font.PLAIN, 20));
        g.fillRect(Mouse.getMouseX() - 32, Mouse.getMouseY() - 32, 64, 64);
        g.drawString("Button: " + Mouse.getMouseB(), 80, 80);
        g.dispose();
        bs.show();
    }

    private void tick() {
        _key.update();
        _player.update();
    }

    public synchronized void start() {
        _isRunning = true;
        _gameThread = new Thread(this, "Arbúcies (MAIN_GAME)");
        _gameThread.start();
    }

    public synchronized void stop() {
        try {
            _gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
