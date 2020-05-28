package co.aplicared.jvm.juego.arbúcies.entity.mob;

import co.aplicared.jvm.juego.arbucies.Arbucies;
import co.aplicared.jvm.juego.arbucies.control.Keyboard;
import co.aplicared.jvm.juego.arbucies.entity.projectile.Projectile;
import co.aplicared.jvm.juego.arbucies.entity.projectile.WizardProjectile;
import co.aplicared.jvm.juego.arbucies.graphics.PlayerSprites;
import co.aplicared.jvm.juego.arbucies.graphics.Sprite;
import co.aplicared.jvm.juego.arbucies.util.Compass;
import co.aplicared.jvm.juego.arbúcies.control.Mouse;
import co.aplicared.jvm.juego.arbúcies.graphics.Screen;

public class Player extends Mob {

    private final Keyboard input;
    private Sprite sprite;
    private int anim = 0;
    private boolean walking = false;

    private int fireRate = 0;

    public Player(Keyboard input) {
        this.sprite = PlayerSprites.BACK.sprite();
        this.input = input;
    }

    public Player(int x, int y, Keyboard input) {
        this.x = x + 0.0;
        this.y = y + 0.0;
        this.input = input;
        this.sprite = PlayerSprites.BACK.sprite();
        fireRate = WizardProjectile.Companion.getFIRE_RATE();
    }

    @Override
    public void update() {
        if (fireRate > 0) fireRate--;
        int xa = 0, ya = 0;
        if (anim < 200) anim++;
        else anim = 0;
        if (input.getUp()) ya--;
        if (input.getDown()) ya++;
        if (input.getLeft()) xa--;
        if (input.getRight()) xa++;

        if (xa != 0 || ya != 0) {
            move(xa, ya);
            walking = true;
        } else {
            walking = false;
        }
        clear();
        updateShooting();
    }

    private void clear() {
        for (int i = 0; i < level.getProjectiles().size(); i++) {
            Projectile p = level.getProjectiles().get(i);
            if (p.isRemoved()) level.getProjectiles().remove(i);
        }
    }

    private void updateShooting() {
        if (Mouse.getMouseB() == 1 && fireRate <= 0) {
            double dx = Mouse.getMouseX() - (Arbucies.Companion.getWindowWidth() >> 1);
            double dy = Mouse.getMouseY() - (Arbucies.Companion.getWindowHeight() >> 1);
            double pDir = Math.atan2(dy, dx);
            shoot(x.intValue(), y.intValue(), pDir);
            fireRate = WizardProjectile.Companion.getFIRE_RATE();
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
                    sprite = PlayerSprites.BACK.spriteAlt();
                }
            }
        }

        if (dir == Compass.SOUTH) {
            sprite = PlayerSprites.FRONT.sprite();
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = PlayerSprites.FRONT.sprite();
                } else {
                    sprite = PlayerSprites.FRONT.spriteAlt();
                }
            }
        }
        if (dir == Compass.EAST) {
            sprite = PlayerSprites.RIGHT.sprite();
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = PlayerSprites.RIGHT.sprite();
                } else {
                    sprite = PlayerSprites.RIGHT.spriteAlt();
                }
            }
        }
        if (dir == Compass.WEST) {
            sprite = PlayerSprites.LEFT.sprite();
            if (walking) {
                if (anim % 20 > 10) {
                    sprite = PlayerSprites.LEFT.sprite();
                } else {
                    sprite = PlayerSprites.LEFT.spriteAlt();
                }
            }
        }

        screen.renderPlayer((int) (x - 16), (int) (y - 16), sprite);
    }
}
