package co.aplicared.jvm.juego.arbúcies.entity;

import co.aplicared.jvm.juego.arbúcies.graphics.Screen;
import co.aplicared.jvm.juego.arbúcies.level.Level;

public abstract class Entity {

    //protected final Random random = new Random();
    public Double x, y;
    protected Level level;
    private boolean _isRemoved = false;

    public void update() {
    }

    public void render(Screen screen) {
    }

    public void remove() {
        _isRemoved = true;
    }

    public boolean isRemoved() {
        return _isRemoved;
    }

    public void init(Level level) {
        this.level = level;
    }
}
