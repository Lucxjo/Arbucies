package co.aplicared.jvm.juego.arbúcies.level;

import co.aplicared.jvm.juego.arbúcies.entity.Entity;
import co.aplicared.jvm.juego.arbúcies.graphics.Screen;
import co.aplicared.jvm.juego.arbúcies.level.tile.Tile;
import co.aplicared.jvm.juego.arbúcies.util.Colours;

import java.util.ArrayList;
import java.util.List;

public class Level {
    protected int width, height;
    protected int[] tilesInt;
    protected int[] tiles;

    private final List<Entity> entities = new ArrayList<>();

    public static Level spawn = new SpawnLevel("/levels/NewSpawnLevel.png");

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        tilesInt = new int[width * height];
        generateLevel();
    }

    public Level(String path) {
        loadLevel(path);
        generateLevel();
    }

    protected void generateLevel() {
    }

    protected void loadLevel(String path) {
    }

    protected void time() {
    }

    public void update() {
        for (Entity entity : entities) {
            entity.update();
        }
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

        for (Entity entity : entities) {
            entity.render(screen);
        }
    }

    // Light Grass: 0xFF0000
    // Dark Grass: 0xFFFF00
    // Light Inferno: 0x7F0000
    // Dark Inferno: 0x7F7F00
    // Stone: 0xC70000
    // Dirt: 0xC7C700

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;

        if (tiles[x + y * width] == Colours.TEX_LIGHT_GRASS.RGBA()) return Tile.lightGrassTile;
        if (tiles[x + y * width] == Colours.TEX_DARK_GRASS.RGBA()) return Tile.darkGrassTile;
        if (tiles[x + y * width] == Colours.TEX_LIGHT_INFERNO.RGBA()) return Tile.lightInfernoTile;
        if (tiles[x + y * width] == Colours.TEX_DARK_INFERNO.RGBA()) return Tile.darkInfernoTile;
        if (tiles[x + y * width] == Colours.TEX_DIRT.RGBA()) return Tile.dirtTile;
        if (tiles[x + y * width] == Colours.TEX_STONE.RGBA()) return Tile.stoneTile;
        if (tiles[x + y * width] == Colours.TEX_WATER.RGBA()) return Tile.waterTile;
        if (tiles[x + y * width] == Colours.PNT_SPAWN.RGBA()) return Tile.dirtTile;
        else return Tile.voidTile;
    }

    public void add(Entity e) {
        entities.add(e);
    }
}
