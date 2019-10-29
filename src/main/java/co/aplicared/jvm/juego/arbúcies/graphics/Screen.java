package co.aplicared.jvm.juego.arbúcies.graphics;

import co.aplicared.jvm.juego.arbúcies.level.tile.Tile;

import java.util.Random;

public class Screen {
    public int width, height;
    public int[] pixels;
    public int mapSize = 64, mapSizeMask = mapSize--;
    public int xOffset, yOffset;

    private int[] tiles = new int[mapSize * mapSize];

    private Random random = new Random();

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];

        for (int i = 0; i < mapSize * mapSize; i++) {
            tiles[i] = random.nextInt(0xFFFFFF);
        }
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    public void renderTile(int xp, int yp, Tile tile) {
        xp -= xOffset;
        yp -= yOffset;

        for (int y = 0; y < tile.sprite.size; y++) {
            int ya = y + yp;
            for (int x = 0; x < tile.sprite.size; x++) {
                int xa = x + xp;
                if (xa < -tile.sprite.size || xa >= width || ya < -tile.sprite.size || ya >= height) break;
                if (xa < 0) xa = 0;
                if (ya < 0) ya = 0;
                pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.size];
            }
        }
    }

    public void setOffset(int yOffset, int xOffset) {
        this.yOffset = yOffset;
        this.xOffset = xOffset;
    }
}
