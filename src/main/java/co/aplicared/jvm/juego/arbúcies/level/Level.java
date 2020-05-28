package co.aplicared.jvm.juego.arbúcies.level;

import co.aplicared.jvm.juego.arbucies.entity.projectile.Projectile;
import co.aplicared.jvm.juego.arbucies.level.tile.Tile;
import co.aplicared.jvm.juego.arbucies.util.Colours;
import co.aplicared.jvm.juego.arbúcies.entity.Entity;
import co.aplicared.jvm.juego.arbúcies.graphics.Screen;

import java.util.ArrayList;
import java.util.List;

public class Level {
    protected int width, height;
    protected int[] tilesInt;
    protected int[] tiles;

    private final List<Entity> entities = new ArrayList<>();

    private final List<Projectile> projectiles = new ArrayList<>();

    public List<Projectile> getProjectiles() {
        return projectiles;
    }

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

        for (Projectile projectile : projectiles) {
            projectile.update();
        }
    }

    public boolean tileCollision(double x, double y, double xa, double ya, int size) {
        boolean solid = false;

        for (int c = 0; c < 4; c++) {
            int xt = (((int) x + (int) xa) + c % 2 * size * 2 - 10) >> 4;
            int yt = (((int) y + (int) ya) + c / 2 * size / 2 + 5) >> 4;

            if (getTile(xt, yt).solid()) solid = true;
        }

        return solid;
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

        for (Projectile projectile : projectiles) {
            projectile.render(screen);
        }
    }

    // Light Grass: 0xFF0000
    // Dark Grass: 0xFFFF00
    // Light Inferno: 0x7F0000
    // Dark Inferno: 0x7F7F00
    // Stone: 0xC70000
    // Dirt: 0xC7C700

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) return Tile.Companion.getVoidTile();

        if (tiles[x + y * width] == Colours.TEX_LIGHT_GRASS.RGBA()) return Tile.Companion.getLightGrassTile();
        if (tiles[x + y * width] == Colours.TEX_DARK_GRASS.RGBA()) return Tile.Companion.getDarkGrassTile();
        if (tiles[x + y * width] == Colours.TEX_LIGHT_INFERNO.RGBA()) return Tile.Companion.getLightInfernoTile();
        if (tiles[x + y * width] == Colours.TEX_DARK_INFERNO.RGBA()) return Tile.Companion.getDarkInfernoTile();
        if (tiles[x + y * width] == Colours.TEX_DIRT.RGBA()) return Tile.Companion.getDirtTile();
        if (tiles[x + y * width] == Colours.TEX_STONE.RGBA()) return Tile.Companion.getStoneTile();
        if (tiles[x + y * width] == Colours.TEX_WATER.RGBA()) return Tile.Companion.getWaterTile();
        if (tiles[x + y * width] == Colours.PNT_SPAWN.RGBA()) return Tile.Companion.getDirtTile();
        else return Tile.Companion.getVoidTile();
    }

    public void add(Entity e) {
        entities.add(e);
    }

    public void add(Projectile p) {
        p.init(this);
        projectiles.add(p);
    }
}
