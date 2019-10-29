package co.aplicared.jvm.juego.arbúcies.entity.mob;

import co.aplicared.jvm.juego.arbúcies.entity.Entity;
import co.aplicared.jvm.juego.arbúcies.graphics.Sprite;

public abstract class Mob extends Entity {

    protected Sprite sprite;
    protected int dir = 0;
    protected boolean moving = false;

    public void move() {
    }

    public void update() {
    }

    private boolean collision() {
        return false;
    }

    public void render() {
    }

}
