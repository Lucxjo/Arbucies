package co.aplicared.jvm.juego.arbúcies.graphics;

public enum PlayerSprites {
    FRONT(0, Sprite.player0Frnt0, Sprite.player0Frnt1),
    LEFT(1, Sprite.player0Left0, Sprite.player0Left1),
    BACK(2, Sprite.player0Bck0, Sprite.player0Bck1),
    RIGHT(0, Sprite.player0Rght0, Sprite.player0Rght1);

    private final int ind;
    private final Sprite spr;
    private final Sprite spr1;

    PlayerSprites(int index, Sprite sprite) {
        this.ind = index;
        this.spr = sprite;
        this.spr1 = sprite;
    }

    PlayerSprites(int index, Sprite sprite1, Sprite sprite2) {
        this.ind = index;
        this.spr = sprite1;
        this.spr1 = sprite2;
    }

    public Sprite sprite() {
        return spr;
    }

    public Sprite altSprite() {
        return spr1;
    }

    public int index() {
        return ind;
    }
}
