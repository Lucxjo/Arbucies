package co.aplicared.jvm.juego.arbúcies.entity.mob;

import co.aplicared.jvm.juego.arbucies.entity.projectile.Projectile;
import co.aplicared.jvm.juego.arbucies.entity.projectile.WizardProjectile;
import co.aplicared.jvm.juego.arbucies.util.Compass;
import co.aplicared.jvm.juego.arbúcies.entity.Entity;
import co.aplicared.jvm.juego.arbúcies.graphics.Sprite;

public abstract class Mob extends Entity {

    protected Sprite sprite;
    protected Compass dir = Compass.NORTH;
    protected boolean moving = false;

    public void move(int xa, int ya) {
        if (xa != 0 && ya != 0) {
            move(xa, 0);
            move(0, ya);
            return;
        }
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

    protected void shoot(int pX, int pY, double dir) {
        Projectile p = new WizardProjectile(x, y, dir);
        level.getProjectiles().add(p);
        level.add(p);
    }

    private boolean collision(int xa, int ya) {
        boolean solid = false;

        for (int c = 0; c < 4; c++) {
            int xt = (int) ((x + xa) + ((c % 2) * 12) - 8) >> 4;
            int yt = (int) ((y + ya) + ((c >> 1) * 16) - 1) >> 4;

            if (level.getTile(xt, yt).solid()) solid = true;
        }

        return solid;
    }

    public void render() {
    }

}
