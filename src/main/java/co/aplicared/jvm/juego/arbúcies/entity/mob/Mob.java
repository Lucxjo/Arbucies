package co.aplicared.jvm.juego.arbúcies.entity.mob;

import co.aplicared.jvm.juego.arbúcies.entity.Entity;
import co.aplicared.jvm.juego.arbúcies.graphics.Sprite;
import co.aplicared.jvm.juego.arbúcies.util.Compass;

public abstract class Mob extends Entity {

    protected Sprite sprite;
    protected Compass dir = Compass.NORTH;
    protected boolean moving = false;

    public void move(int xa, int ya) {
        if (xa > 0) dir = Compass.EAST;
        if (xa < 0) dir = Compass.WEST;
        if (ya > 0) dir = Compass.SOUTH;
        if (ya < 0) dir = Compass.NORTH;

        if (!collision(xa, ya)) {
            x += xa;
            y += ya;
        }
    }

    public void update() {
    }

    private boolean collision(int xa, int ya) {
        boolean solid = false;

        if (level.getTile((x + xa) / 16, (y + ya) / 16).solid()) solid = true;
        return solid;
    }

    public void render() {
    }

}
