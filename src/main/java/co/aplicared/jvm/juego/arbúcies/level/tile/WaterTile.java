package co.aplicared.jvm.juego.arbúcies.level.tile;

import co.aplicared.jvm.juego.arbucies.graphics.Sprite;
import co.aplicared.jvm.juego.arbúcies.graphics.Screen;

public class WaterTile extends Tile {
    protected WaterTile(Sprite sprite) {
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
