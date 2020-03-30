package co.aplicared.jvm.juego.arbúcies.level.tile;

import co.aplicared.jvm.juego.arbúcies.graphics.Screen;
import co.aplicared.jvm.juego.arbúcies.graphics.Sprite;

public class StoneTile extends Tile {
    protected StoneTile(Sprite sprite) {
        super(sprite);
    }

    @Override
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);
    }

    @Override
    public boolean solid() {
        return true;
    }
}
