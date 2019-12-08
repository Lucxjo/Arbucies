package co.aplicared.jvm.juego.arbúcies.level.tile;

import co.aplicared.jvm.juego.arbúcies.graphics.Screen;
import co.aplicared.jvm.juego.arbúcies.graphics.Sprite;

public class Tile {
    public static Tile lightGrassTile = new GrassTile(Sprite.lightGrassSprite);
    public static Tile darkGrassTile = new GrassTile(Sprite.darkGrassSprite);
    public static Tile lightInfernoTile = new GrassTile(Sprite.lightInfernoSprite);
    public static Tile darkInfernoTile = new GrassTile(Sprite.darkInfernoSprite);
    public static Tile stoneTile = new StoneTile(Sprite.stoneSprite);
    public static Tile dirtTile = new GrassTile(Sprite.dirtSprite);

    public static Tile voidTile = new VoidTile(Sprite.voidSprite);

    public Sprite sprite;
    public int x, y;

    protected Tile(Sprite sprite) {
        this.sprite = sprite;
    }

    public void render(int x, int y, Screen screen) {
    }

    protected boolean solid() {
        return false;
    }
}
