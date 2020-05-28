package co.aplicared.jvm.juego.arbúcies.level.tile;

import co.aplicared.jvm.juego.arbucies.graphics.Sprite;
import co.aplicared.jvm.juego.arbúcies.graphics.Screen;

public class BrickTile extends Tile {
    protected BrickTile(Sprite sprite) {
        super(sprite);
    }

    @Override
    public boolean solid() {
        return true;
    }

    @Override
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);
    }
}
