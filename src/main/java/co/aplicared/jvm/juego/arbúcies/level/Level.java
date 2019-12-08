package co.aplicared.jvm.juego.arbúcies.level;

import co.aplicared.jvm.juego.arbúcies.graphics.Screen;
import co.aplicared.jvm.juego.arbúcies.level.tile.Tile;

public class Level {
    protected int width, height;
    protected int[] tiles;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new int[width * height];
        generateLevel();
    }

    public Level(String path) {
        loadLevel(path);
    }

    protected void generateLevel() {
    }

    private void loadLevel(String path) {
    }

    protected void time() {
    }

    protected void update() {
    }

    public void render(int xScroll, int yScroll, Screen screen) {
        screen.setOffset(yScroll, xScroll);

        int x0 = xScroll >> 4;
        int x1 = (xScroll + screen.width + 16) >> 4;
        int y0 = yScroll >> 4;
        int y1 = (yScroll + screen.height + 16) >> 4;

        for (int y = y0; y < y1; y++) {
            for (int x = x0; x < x1; x++) {
                getTile(x, y).render(x, y, screen);
            }
        }
    }

    private Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;

        if (tiles[x + y * width] == 0) return Tile.lightGrassTile;
        if (tiles[x + y * width] == 1) return Tile.darkGrassTile;
        if (tiles[x + y * width] == 4) return Tile.lightInfernoTile;
        if (tiles[x + y * width] == 5) return Tile.darkInfernoTile;
        if (tiles[x + y * width] == 2) return Tile.dirtTile;
        if (tiles[x + y * width] == 3) return Tile.stoneTile;
        else return Tile.voidTile;
    }
}
