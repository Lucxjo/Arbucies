package co.aplicared.jvm.juego.arbúcies.level.tile;

import co.aplicared.jvm.juego.arbucies.graphics.Sprite;
import co.aplicared.jvm.juego.arbúcies.graphics.Screen;

public class Tile {

    // Non-solid tiles
    public static Tile lightGrassTile = new GrassTile(Sprite.Tiles.INSTANCE.getLightGrassSprite());
    public static Tile darkGrassTile = new GrassTile(Sprite.Tiles.INSTANCE.getLightGrassSprite());
    public static Tile lightInfernoTile = new GrassTile(Sprite.Tiles.INSTANCE.getLightInfernoSprite());
    public static Tile darkInfernoTile = new GrassTile(Sprite.Tiles.INSTANCE.getDarkInfernoSprite());
    public static Tile dirtTile = new GrassTile(Sprite.Tiles.INSTANCE.getDirtSprite());

    public static Tile voidTile = new VoidTile(Sprite.Tiles.INSTANCE.getVoidSprite());

    // Solid tiles
    public static Tile brickTile = new BrickTile(Sprite.Tiles.INSTANCE.getBrickSprite());
    public static Tile stoneTile = new StoneTile(Sprite.Tiles.INSTANCE.getStoneSprite());
    public static Tile cobbleTile = new StoneTile(Sprite.Tiles.INSTANCE.getCrackedStoneSprite());
    public static Tile mossyCobbleTile = new StoneTile(Sprite.Tiles.INSTANCE.getMossyCrackedStoneSprite());
    public static Tile birchWoodTile = new WoodTile(Sprite.Tiles.INSTANCE.getBirchWoodSprite());
    public static Tile waterTile = new WaterTile(Sprite.Tiles.INSTANCE.getWaterSprite());

    public Sprite sprite;
    public int x, y;

    protected Tile(Sprite sprite) {
        this.sprite = sprite;
    }

    public void render(int x, int y, Screen screen) {
    }

    public boolean solid() {
        return false;
    }

    protected boolean breakable() {
        return false;
    }
}
