package co.aplicared.jvm.juego.arbúcies;

import javax.swing.*;
import java.awt.*;

public class Game extends Canvas implements Runnable {
    public static int width = 300;
    public static int height = width / 16 * 9;
    public static int scale = 3;

    public final static String title = "Arbúcies";

    private Thread gameThread;
    private JFrame frame;

    private boolean isRunning = false;

    public Game() {
        Dimension size = new Dimension(width * scale, height * scale);
        frame = new JFrame();
        frame.setPreferredSize(size);
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.frame.setResizable(false);
        game.frame.setTitle(title);
        game.frame.add(game);
        game.frame.pack();
        game.frame.requestFocus();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);
    }

    public synchronized void start() {
        gameThread = new Thread(this, "Arbúcies Game Thread");
        gameThread.start();
        isRunning = true;
    }

    public synchronized void stop() {
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            //
        }
    }
}
