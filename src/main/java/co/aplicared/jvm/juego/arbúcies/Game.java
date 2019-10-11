package co.aplicared.jvm.juego.arbúcies;

import co.aplicared.jvm.juego.arbúcies.graphics.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas implements Runnable {
    public static int width = 300;
    public static int height = width / 16 * 9;
    public static int scale = 3;

    public final static String title = "Arbúcies";

    private Thread _gameThread;
    private JFrame _frame;

    private boolean _isRunning = false;

    private Screen _screen;

    private BufferedImage _image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] _pixels = ((DataBufferInt) _image.getRaster().getDataBuffer()).getData();

    public Game() {
        Dimension size = new Dimension(width * scale, height * scale);

        _screen = new Screen(width, height);

        _frame = new JFrame();
        _frame.setPreferredSize(size);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game._frame.setResizable(false);
        game._frame.setTitle(title);
        game._frame.add(game);
        game._frame.pack();
        game._frame.requestFocus();
        game._frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game._frame.setLocationRelativeTo(null);
        game._frame.setVisible(true);

        game.start();
    }

    public synchronized void start() {
        _gameThread = new Thread(this, "Arbúcies Game Thread");
        _gameThread.start();
        _isRunning = true;
    }

    public synchronized void stop() {
        try {
            _gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (_isRunning) {
            tick();
            render();
        }
    }

    public void tick() {
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        _screen.render();

        for (int i = 0; i < _pixels.length; i++) {
            _pixels[i] = _screen.pixels[i];
        }

        Graphics g = bs.getDrawGraphics();
        g.drawImage(_image, 0, 0, getWidth(), getHeight(), null);
        g.dispose();
        bs.show();
    }
}
