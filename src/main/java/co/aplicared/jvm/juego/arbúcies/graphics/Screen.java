package co.aplicared.jvm.juego.arbúcies.graphics;

import co.aplicared.jvm.juego.arbucies.entity.projectile.Projectile;
import co.aplicared.jvm.juego.arbúcies.level.tile.Tile;
import co.aplicared.jvm.juego.arbúcies.util.Colours;

import java.util.Arrays;
import java.util.Random;

public class Screen {
    public int width, height;
    public int[] pixels;
    public int mapSize = 64, mapSizeMask = mapSize--;
    public int xOffset, yOffset;

    private final int[] tiles = new int[mapSize * mapSize];

    private final Random random = new Random();

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels = new int[width * height];

        for (int i = 0; i < mapSize * mapSize; i++) {
            tiles[i] = random.nextInt(0xFFFFFF);
        }
    }

    public void clear() {
        Arrays.fill(pixels, 0);
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

    public void renderProjectile(int xp, int yp, Projectile p) {
        xp -= xOffset;
        yp -= yOffset;

        for (int y = 0; y < p.getSpriteSize(); y++) {
            int ya = y + yp;
            for (int x = 0; x < p.getSpriteSize(); x++) {
                int xa = x + xp;
                if (xa < -p.getSpriteSize() || xa >= width || ya < -p.getSpriteSize() || ya >= height) break;
                if (xa < 0) xa = 0;
                if (ya < 0) ya = 0;
                int col = p.getSprite().pixels[x + y * p.getSpriteSize()];
                if (col != Colours.TRANSPARENT.RGBA()) pixels[xa + ya * width] = col;
            }
        }
    }

    public void renderPlayer(int xp, int yp, Sprite sprite) {
        xp -= xOffset;
        yp -= yOffset;

        for (int y = 0; y < 32; y++) {
            int ya = y + yp;
            for (int x = 0; x < 32; x++) {
                int xa = x + xp;
                if (xa < -32 || xa >= width || ya < 0 || ya >= height) break;
                if (xa < 0) xa = 0;
                int colour = sprite.pixels[x + y * 32];
                if (colour != Colours.TRANSPARENT.RGBA()) pixels[xa + ya * width] = colour;
            }
        }
    }

    public void setOffset(int yOffset, int xOffset) {
        this.yOffset = yOffset;
        this.xOffset = xOffset;
    }
}
