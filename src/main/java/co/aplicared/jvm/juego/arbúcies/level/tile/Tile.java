package co.aplicared.jvm.juego.arbúcies.level.tile;

import co.aplicared.jvm.juego.arbúcies.graphics.Screen;
import co.aplicared.jvm.juego.arbúcies.graphics.Sprite;

public class Tile {
    public static Tile grassTile = new GrassTile(Sprite.grassSprite);
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
