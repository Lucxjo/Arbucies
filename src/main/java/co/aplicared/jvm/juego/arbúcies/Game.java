package co.aplicared.jvm.juego.arbúcies;

import co.aplicared.jvm.juego.arbúcies.control.Keyboard;
import co.aplicared.jvm.juego.arbúcies.entity.mob.Player;
import co.aplicared.jvm.juego.arbúcies.graphics.Screen;
import co.aplicared.jvm.juego.arbúcies.level.Level;
import co.aplicared.jvm.juego.arbúcies.level.RandomLevel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas implements Runnable {

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

    public Game() {
        Dimension size = new Dimension(width * scale, height * scale);

        _gameFrame = new JFrame();
        setPreferredSize(size);

        _key = new Keyboard();
        _level = new RandomLevel(64, 64);
        _screen = new Screen(width, height);
        _player = new Player(_key);

        addKeyListener(_key);
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
                _gameFrame.setTitle(title + " || TPS: " + ticks + " | FPS: " + frames);
                ticks = 0;
                frames = 0;
            }
        }
    }

    private void render() {
        BufferStrategy bs = getBufferStrategy();

        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        _screen.clear();
        _level.render(_player.x, _player.y, _screen);

        for (int i = 0; i < _pixels.length; i++) {
            _pixels[i] = _screen.pixels[i];
        }

        Graphics g = bs.getDrawGraphics();
        g.drawImage(_image, 0, 0, getWidth(), getHeight(), null);
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
