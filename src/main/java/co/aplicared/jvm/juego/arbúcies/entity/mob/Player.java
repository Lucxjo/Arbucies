package co.aplicared.jvm.juego.arbúcies.entity.mob;

import co.aplicared.jvm.juego.arbúcies.control.Keyboard;
import co.aplicared.jvm.juego.arbúcies.graphics.PlayerSprites;
import co.aplicared.jvm.juego.arbúcies.graphics.Screen;
import co.aplicared.jvm.juego.arbúcies.graphics.Sprite;
import co.aplicared.jvm.juego.arbúcies.util.Compass;

@Deprecated
public class Player extends Mob {

    private Keyboard input;
    private Sprite sprite;
    private int anim = 0;
    private boolean walking = false;

    public Player(Keyboard input) {
        this.sprite = PlayerSprites.BACK.sprite();
        this.input = input;
    }

    public Player(int x, int y, Keyboard input) {
        this.x = x;
        this.y = y;
        this.input = input;
        this.sprite = PlayerSprites.BACK.sprite();
    }

    @Override
    public void update() {
        int xa = 0, ya = 0;
        if (anim < 200) anim++;
        else anim = 0;
        if (input.up) ya--;
        if (input.down) ya++;
        if (input.left) xa--;
        if (input.right) xa++;

        if (xa != 0 || ya != 0) {
            move(xa, ya);
            walking = true;
        } else {
            walking = false;
        }
    }

    @Override
    public void render(Screen screen) {
        if (dir == Compass.NORTH) {
            sprite = PlayerSprites.BACK.sprite();
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = PlayerSprites.BACK.sprite();
                } else {
                    sprite = PlayerSprites.BACK.altSprite();
                }
            }
        }

        if (dir == Compass.SOUTH) {
            sprite = PlayerSprites.FRONT.sprite();
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = PlayerSprites.FRONT.sprite();
                } else {
                    sprite = PlayerSprites.FRONT.altSprite();
                }
            }
        }
        if (dir == Compass.EAST) {
            sprite = PlayerSprites.RIGHT.sprite();
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = PlayerSprites.RIGHT.sprite();
                } else {
                    sprite = PlayerSprites.RIGHT.altSprite();
                }
            }
        }
        if (dir == Compass.WEST) {
            sprite = PlayerSprites.LEFT.sprite();
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = PlayerSprites.LEFT.sprite();
                } else {
                    sprite = PlayerSprites.LEFT.altSprite();
                }
            }
        }

        screen.renderPlayer(x - 16, y - 16, sprite);
    }
}
