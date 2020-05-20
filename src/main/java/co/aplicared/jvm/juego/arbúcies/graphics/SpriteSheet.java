package co.aplicared.jvm.juego.arbúcies.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SpriteSheet {
    public static SpriteSheet terrain = new SpriteSheet("/textures/TerrainSS.png", 256);
    public static SpriteSheet player = new SpriteSheet("/textures/PlayerSS.png", 256);
    public static SpriteSheet projectile = new SpriteSheet("/textures/ProjectileSS.png", 48);

    public String path;
    public int size;
    public int[] pixels;

    public SpriteSheet(String path, int size) {
        this.path = path;
        this.size = size;
        pixels = new int[size * size];

        load();
    }

    public void load() {
        try {
            BufferedImage i = ImageIO.read(SpriteSheet.class.getResource(path));
            int w = i.getWidth();
            int h = i.getHeight();
            i.getRGB(0, 0, w, h, pixels, 0, w);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
