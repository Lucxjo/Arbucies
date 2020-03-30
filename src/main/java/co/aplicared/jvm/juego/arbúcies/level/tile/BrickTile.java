package co.aplicared.jvm.juego.arbúcies.level.tile;

import co.aplicared.jvm.juego.arbúcies.graphics.Screen;
import co.aplicared.jvm.juego.arbúcies.graphics.Sprite;

public class BrickTile extends Tile {
    protected BrickTile(Sprite sprite) {
        super(sprite);
    }

    @Override
    protected boolean solid() {
        return true;
    }

    @Override
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);
    }
}
