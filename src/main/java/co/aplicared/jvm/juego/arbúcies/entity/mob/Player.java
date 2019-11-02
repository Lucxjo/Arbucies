package co.aplicared.jvm.juego.arbúcies.entity.mob;

import co.aplicared.jvm.juego.arbúcies.control.Keyboard;
import co.aplicared.jvm.juego.arbúcies.graphics.PlayerSprites;
import co.aplicared.jvm.juego.arbúcies.graphics.Screen;

public class Player extends Mob {

    private Keyboard input;

    public Player(Keyboard input) {
        this.input = input;
    }

    public Player(int x, int y, Keyboard input) {
        this.x = x;
        this.y = y;
        this.input = input;
    }

    @Override
    public void update() {
        int xa = 0, ya = 0;
        if (input.up) ya--;
        if (input.down) ya++;
        if (input.left) xa--;
        if (input.right) xa++;

        if (xa != 0 || ya != 0) move(xa, ya);
    }

    @Override
    public void render(Screen screen) {
        screen.renderPlayer(x, y, PlayerSprites.NORTH.sprite());
    }
}
