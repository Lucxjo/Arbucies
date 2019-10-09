package co.aplicared.jvm.juego.arbúcies;

import javax.swing.*;
import java.awt.*;

public class Game extends Canvas implements Runnable {
    public static int width = 300;
    public static int height = width / 16 * 9;
    public static int scale = 3;

    private Thread gameThread;
    private JFrame frame;

    private boolean isRunning = false;

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
